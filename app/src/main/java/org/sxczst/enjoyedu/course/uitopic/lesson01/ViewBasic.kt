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
     *  todo AttributeSet 与自定义属性
     *  系统自带的 View 可以在 xml 文件中配置属性，对于写好的自定义 View 同样可以在 xml 文件中配置属性，
     *  为了使自定义的 View 的属性可以在 xml 文件中配置，需要以下 4 个步骤：
     *  1. 通过 <declare-styleable> 为自定义 View 添加属性。
     *  2. 在 xml 文件中为相应的属性声明属性值。
     *  3. 在运行时（一般为构造函数）获取属性值。
     *  4. 将获取到的属性值应用到 View。
     *
     *  todo View 视图结构
     *  PhoneWindow 是 Android 系统中最基本的窗口系统，继承自 Window 类，
     *      负责管理界面显示以及事件响应。它是 Activity 与 View 系统交互的接口。
     *  DecorView 是 PhoneWindow 中的起始点 View，继承于 View 类，作为整个视图容器来使用。
     *      用于设置窗口属性。它本质上是一个 FrameLayout
     *  ViewRoot 在 Activity 启动时创建，负责管理、布局、渲染窗口 UI。
     *  对于多 View 的视图，其结构时树形结构。
     *
     *  todo Android 坐标系
     *  - 屏幕的左上角为坐标原点
     *  - 向右为 x 轴增大方向
     *  - 向下为 y 轴增大方向
     *  - 角度为顺时针方向
     *
     *  todo View 的位置
     *  - Top：子 View 上边界到父 View 上边界的距离
     *  - Left：子 View 左边界到父 View 左边界的距离
     *  - Bottom：子 View 下边界到父 View 上边界的距离
     *  - Right: 子 View 右边界到父 View 左边界的距离
     *  - getX() getY()：触摸点相对于其所在组件坐标系的坐标
     *  - getRawX() getRawY()：触摸点相对于屏幕默认坐标系的坐标
     *
     *  todo Android 中颜色相关内容
     *
     *  todo View 树的绘制流程
     *  ViewRootImpl:ViewParent
     *  WindowManagerGlobal.addView -> ViewRootImpl.setView -> ViewRootImpl.requestLayout -> ViewRootImpl.scheduleTraversals
     *  -> TraversalRunnable.run -> ViewRootImpl.doTraversal -> ViewRootImpl.performTraversals
     *  -> 三大流程：测量，布局，绘制。
     *
     *  todo Android MeasureSpec
     *  测量模式：高 2 位表示，即 31，32 位。
     *      UNSPECIFIED 父控件不做任何限制
     *      EXACTLY 精确的大小
     *      AT_MOST 不能大于父控件的大小
     *  具体测量大小：低 30 位表示
     *
     *  常用：makeMeasureSpec()，getMode()，getSize()
     *
     *  ViewGroup.getChildMeasureSpec() 会发生多次测量
     *
     */

    /**
     * 测量决定 View 的大小。
     *
     * 1. 系统为什么要有 measure 过程？
     *      view 宽高允许设置为 wrap_content、match_parent，在显示之前需要计算其真正的大小。
     * 2. measure 过程都干了什么事情？
     *      将 View 属性设置的自适应大小，计算出显示在屏幕上的具体像素大小。
     * 3. 对于自适应的尺寸机制，如何合理地测量一颗 View 树？
     *
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