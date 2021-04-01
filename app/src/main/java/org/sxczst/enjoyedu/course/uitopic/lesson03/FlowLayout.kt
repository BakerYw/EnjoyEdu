package org.sxczst.enjoyedu.course.uitopic.lesson03

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import org.sxczst.enjoyedu.R

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

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    class LayoutParams : MarginLayoutParams {
        var gravity = -1

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
            val a =
                context.obtainStyledAttributes(attrs, R.styleable.FlowLayout_Layout)
            try {
                gravity = a.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, -1)
            } finally {
                a.recycle()
            }
        }
    }
}