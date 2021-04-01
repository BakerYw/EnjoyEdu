package org.sxczst.enjoyedu.course.uitopic.lesson02

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max

/**
 * @author      sxczst
 * @date        2021/3/31 20:58
 */
class MyViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {


    /**
     * 1. 确定自身的大小
     * 2. 确定子 View 的大小
     *
     * todo 流程
     * 1. ViewGroup 开始测量自己的尺寸
     * 2. 为每个子 View 计算测量的限制信息
     * 3. 把上一步确定的限制信息，传递给每一个子 View，然后子 View 开始 measure 自己的尺寸。
     * 4. ViewGroup 获取子 View 测量完成后的尺寸。
     * 5. ViewGroup 根据自身的情况，计算自己的尺寸。
     * 6. 保存自己的尺寸，执行 onLayout 流程。
     *
     * todo onMeasure 方法中常用的方法
     * 1. 获取子 View 的数量
     * 2. 获取第 i 个子控件
     * 3. 设置或获取子控件的宽或高
     * 4. 测量子 View 的宽高
     * 5. 执行完 measureChild() 方法后就可以通过这种方式获取子 View 的宽高值
     * 6. 获取控件的四周内边距
     * 7. 重新设置控件的宽高
     *
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // 1. 测量自身
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 2. 为每个子 View 计算测量的限制信息 Mode Size
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        // 3. 把上一步确定的限制信息，传递给每一个子 View，然后子 View 开始 measure 自己的尺寸。
        val childCount = childCount
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            val layoutParams = childView.layoutParams
            val childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, layoutParams.width)
            val childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, layoutParams.height)
            childView.measure(childWidthSpec, childHeightSpec)
        }

        // 4. ViewGroup 获取子 View 测量完成后的尺寸。
        // 5. ViewGroup 根据自身的情况，计算自己的尺寸。
        var width = 0
        var height = 0
        when (widthMode) {
            MeasureSpec.UNSPECIFIED,
            MeasureSpec.AT_MOST -> {
                for (i in 0 until childCount) {
                    val childView = getChildAt(i)
                    val widthAddOffset = i * OFFSET + childView.measuredWidth
                    width = max(width, widthAddOffset)
                }
            }
            MeasureSpec.EXACTLY -> {
                width = widthSize
            }
        }

        when (heightMode) {
            MeasureSpec.UNSPECIFIED,
            MeasureSpec.AT_MOST -> {
                for (i in 0 until childCount) {
                    val childView = getChildAt(i)
                    height += childView.measuredHeight
                }
            }
            MeasureSpec.EXACTLY -> {
                height = heightSize
            }
        }

        // 6. 保存自己的尺寸，执行 onLayout 流程。
        setMeasuredDimension(width, height)
    }

    /**
     * todo layout 流程
     *
     * todo 作业：layout 时序图
     *
     * 1. 根据规则确定子 View 的位置。
     *
     * todo 通用实现方式
     * 1. 遍历子 View
     * 2. 确定自己的规则
     * 3. 子 View 的测量尺寸
     * 4. left top right bottom
     * 5. child.layout
     *
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left: Int
        var top = 0
        var right: Int
        var bottom: Int
        // 1. 遍历子 View
        val childCount = childCount
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            left = i * OFFSET
            right = left + childView.measuredWidth
            bottom = top + childView.measuredHeight
            childView.layout(left, top, right, bottom)
            top = bottom
        }
        // 2. 确定自己的规则
        // 3. 子 View 的测量尺寸
        // 4. left top right bottom
        // 5. child.layout
    }

    companion object {

        /**
         * 表示缩进的尺寸
         */
        const val OFFSET = 100
    }

}