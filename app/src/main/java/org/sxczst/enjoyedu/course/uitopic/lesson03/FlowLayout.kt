package org.sxczst.enjoyedu.course.uitopic.lesson03

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import org.sxczst.enjoyedu.R
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

    private var lineViews = arrayListOf<View>()

    private val views = arrayListOf<List<View>>()

    private val heights = arrayListOf<Int>()

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
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

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
                views += lineViews
                lineViews = arrayListOf()
                flowLayoutWidth = max(flowLayoutWidth, currentWidth)
                flowLayoutHeight += currentHeight
                heights += currentHeight
                currentWidth = 0
                currentHeight = 0
            }
            lineViews.add(childView)
            currentWidth += childWidth
            currentHeight = max(currentHeight, childHeight)
        }

        // FlowLayout 最终的宽高
        setMeasuredDimension(
            if (widthMode == MeasureSpec.EXACTLY) widthSize else flowLayoutWidth,
            if (heightMode == MeasureSpec.EXACTLY) heightSize else flowLayoutHeight,
        )
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