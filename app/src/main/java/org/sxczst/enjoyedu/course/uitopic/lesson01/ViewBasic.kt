package org.sxczst.enjoyedu.course.uitopic.lesson01

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * @author      sxczst
 * @date        2021/3/25 21:10
 *
 * 第一期 Android 自定义系列一
 */
class ViewBasic @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    /**
     *  todo 自定义控件的分类
     *  自定义 View ：只需要重写 onMeasure() 和 onDraw()
     *  自定义 ViewGroup ：只需要重写 onMeasure() 和 onLayout()
     *
     *  todo View 的分类
     *  单一视图：即一个 View，如 TextView    特点：不包含子 View
     *  视图组：即多个 View 组成的 ViewGroup，如 LinearLayout   特点：包含子 View
     *
     *  todo TextView
     *  EditText
     *  StaticLayout
     *
     *  todo View 的构造函数
     *  (context) 在 Java 代码里面 new 使用。
     *  (context attrs) 在 .xml 文件里声明使用，自定义属性是从 AttributeSet 参数传进来的。
     *  (context attrs defStyleAttr) 不会自动调用，一般是在第二个构造函数里主动调用，如：View 有 Style 属性时。
     *  (context attrs defStyleAttr defStyleRes) API 21 之后才使用，不会自动调用，一般是在第二个构造函数里主动调用，如：View 有 Style 属性时。
     *
     */

    /**
     * 测量决定 View 的大小。
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    /**
     * 布局决定 View 在 ViewGroup 中的位置。
     */
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    /**
     * 绘制决定如何绘制这个 View。
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}