package org.sxczst.enjoyedu.course.uitopic.lesson03

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.Scroller
import org.sxczst.enjoyedu.R
import kotlin.math.abs
import kotlin.math.max

/**
 * @author      sxczst
 * @date        2021/4/1 20:50
 *
 * todo 流式布局
 * 把子控件从左到右摆放，如果一行放不下，就自动换行摆放
 *
 * todo 自定义布局流程
 * 1. 自定义属性：声明，设置，解析获取自定义值
 * 2. 测量：在 onMeasure 中，MeasureSpec.AT_MOST/EXACTLY，自身的宽高 / child 的宽高
 * 3. 布局：在 onLayout 中，根据自己的规则来确定 children 的位置
 * 4. 绘制：在 onDraw 中，
 * 5. 处理 LayoutParams。
 * 6. 触摸反馈：滑动事件
 */
class FlowLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    // 初始化参数列表

    private lateinit var lineViews: ArrayList<View>

    private lateinit var views: ArrayList<List<View>>

    private lateinit var heights: ArrayList<Int>

    /**
     * 用来判断是不是一次滑动
     */
    private var mTouchSlop = 0

    private var mLastInterceptX = 0f

    private var mLastInterceptY = 0f

    /**
     * 表示当前是否需要滑动
     */
    private var scrollable = false

    /**
     * 代表本身的测量高度
     */
    private var measureHeight = 0

    /**
     * 表示内容的高度
     */
    private var realHeight = 0

    /**
     * 表示上一次滑动的位置
     */
    private var mLastY = 0f

    /**
     * todo Scroller
     */
    private val mScroller = Scroller(context)

    init {
        /**
         * todo 自定义属性
         * 1. 在 attrs.xml 中声明
         * 2. 引入命名空间
         * 3. 解析
         */
        val a = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout)
        try {

        } finally {
            a.recycle()
        }

        /**
         * todo 获取最小滑动距离
         */
        val configuration = ViewConfiguration.get(context)
        mTouchSlop = configuration.scaledPagingTouchSlop
    }

    private fun init() {
        lineViews = arrayListOf()

        views = arrayListOf()

        heights = arrayListOf()
    }

    /**
     * 当前这一系列的事件是由本身来消费，还是交由子 View 来消费
     */
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val interceptX = ev.x
        val interceptY = ev.y

        val intercepted = when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                // last XY 初始化
                mLastInterceptX = interceptX
                mLastInterceptY = interceptY
                false
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = interceptX - mLastInterceptX
                val dy = interceptY - mLastInterceptY
                // true 表示本身需要拦截处理
                abs(dx) < abs(dy) && abs(dy) > mTouchSlop
            }
            MotionEvent.ACTION_UP -> {
                false
            }
            else -> {
                false
            }
        }
        mLastInterceptX = interceptX
        mLastInterceptY = interceptY
        return intercepted
    }

    /**
     * 处理滑动
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!scrollable) {
            return super.onTouchEvent(event)
        }
        val currentY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (!mScroller.isFinished) {
                    mScroller.abortAnimation()
                }
                mLastY = currentY
            }
            MotionEvent.ACTION_MOVE -> {
                // 本次手势滑动了多大距离
                val dy = mLastY - currentY
                // 已经偏移的距离
                val oldScrollY = scrollY
                // 这是本次需要偏移的距离 = 之前已经偏移了的距离 + 本次手势滑动的距离
                var scrollY = oldScrollY + dy.toInt()
                // 上边界处理
                if (scrollY < 0) {
                    scrollY = 0
                }
                // 下边界处理
                if (scrollY > realHeight - measureHeight) {
                    scrollY = realHeight - measureHeight
                }
                mScroller.startScroll(0, oldScrollY, 0, scrollY)
                invalidate()
                mLastY = currentY
            }
            MotionEvent.ACTION_UP -> {

            }
            else -> {
            }
        }
        return super.onTouchEvent(event)
    }

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            scrollTo(0, mScroller.currY)
            postInvalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        measureHeight = heightSize

        /**
         * 记录当前行的宽度和高度
         * 宽度是当前行子 View 的宽度之和
         * 高度是当前行所有子 View 中高度的最大值
         */
        var currentWidth = 0
        var currentHeight = 0

        /**
         * 整个流式布局的宽度和高度
         * 宽度是所有行中宽度的最大值
         * 高度是所有行的高度的累加
         */
        var flowLayoutWidth = 0
        var flowLayoutHeight = 0

        // 初始化参数列表
        init()

        // 遍历所有的子 View，对子 View 进行测量，分配到具体的行
        val childCount = childCount
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            // 测量子 View 获取到当前子 View 测量的宽高
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            // 获取到当前子 View 的测量的宽高
            val childWidth = childView.measuredWidth
            val childHeight = childView.measuredHeight

            val layoutParams = childView.layoutParams
            // 判断当前行的剩余宽度是否可以放得下 下一个子 View，
            // 如果放不下，就换行 并保存当前行的所有子 View，累加行高，当前的宽度，高度 置零。
            if (currentWidth + childWidth > widthSize) {
                // 换行
                if (lineViews.size == 1 && lineViews[0].layoutParams.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                    currentHeight = Utils.dp2px(150)
                }
                views.add(lineViews)
                lineViews = arrayListOf()
                flowLayoutWidth = max(flowLayoutWidth, currentWidth)
                flowLayoutHeight += currentHeight
                heights.add(currentHeight)
                currentWidth = 0
                currentHeight = 0
            }
            lineViews.add(childView)
            currentWidth += childWidth
            if (layoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT) {
                currentHeight = max(currentHeight, childHeight)
            }

            if (i == childCount - 1) {
                // 最后一行
                views.add(lineViews)
                flowLayoutWidth = max(flowLayoutWidth, currentWidth)
                flowLayoutHeight += currentHeight
                heights.add(currentHeight)
            }
        }

        // 重新测量一次 layout_height = match_parent
        reMeasureChild(widthMeasureSpec, heightMeasureSpec)

        if (heightMode == MeasureSpec.EXACTLY) {
            flowLayoutHeight = max(heightSize, flowLayoutHeight)
        }

        realHeight = flowLayoutHeight
        scrollable = realHeight > measureHeight

        // FlowLayout 最终的宽高
        setMeasuredDimension(
            if (widthMode == MeasureSpec.EXACTLY) widthSize else flowLayoutWidth,
            flowLayoutHeight,
        )
    }


    /**
     * 重新测量一次 layout_height = match_parent
     */
    private fun reMeasureChild(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val lineCount = views.size
        for (i in 0 until lineCount) {
            // 每一行行高
            val lineHeight = heights[i]
            // 每一行的子 View
            val lineViews = views[i]
            val lineViewSize = lineViews.size
            for (j in 0 until lineViewSize) {
                val childView = lineViews[j]
                val layoutParams = childView.layoutParams
                if (layoutParams.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                    val childWidthSpec =
                        getChildMeasureSpec(widthMeasureSpec, 0, layoutParams.width)
                    val childHeightSpec =
                        getChildMeasureSpec(heightMeasureSpec, 0, lineHeight)
                    childView.measure(childWidthSpec, childHeightSpec)
                }
            }
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var currentX = 0
        var currentY = 0
        val lineCount = views.size
        for (i in 0 until lineCount) {
            // 大循环中，考虑所有的子 View，一行一行的布局

            // 取出一行
            val lineViews = views[i]
            // 取出当前行高
            val lineHeight = heights[i]
            val lineViewSize = lineViews.size
            for (j in 0 until lineViewSize) {
                // 布局当前行的每一个 View
                val childView = lineViews[j]
                val left = currentX
                val top = currentY
                val right = left + childView.measuredWidth
                val bottom = top + childView.measuredHeight
                childView.layout(left, top, right, bottom)

                // 确定下一个 View 的 left
                currentX += childView.measuredWidth
            }
            currentY += lineHeight
            currentX = 0
        }
    }

    class LayoutParams : ViewGroup.MarginLayoutParams {
        var gravity = -1

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
            val a =
                context.obtainStyledAttributes(attrs, R.styleable.FlowLayout_Layout)
            try {
                gravity = a.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, gravity)
            } finally {
                a.recycle()
            }
        }
    }
}