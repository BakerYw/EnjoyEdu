package org.sxczst.enjoyedu.course.uitopic.recyclerviewcache.srl_vp

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

/**
 * @author      sxczst
 * @date        2021/4/12 20:19
 */
class CustomVPInner : ViewPager {

    private var mLastX: Int = 0

    private var mLastY: Int = 0

    private var mStartX: Int = 0

    private var mStartY: Int = 0

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    /**
     * 尝试解决：SwipeRefreshLayout + ViewPager + ListView 的冲突问题。
     */
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        // TODO: 2021/4/12 解决滑动冲突失败
        // 外部拦截法
        val x = ev.x.toInt()
        val y = ev.y.toInt()
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                mLastX = ev.x.toInt()
                mLastY = ev.y.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX = x - mLastX
                val deltaY = y - mLastY
                if (abs(deltaX) > abs(deltaY)) {
                    return true
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                mStartX = ev.x.toInt()
                mStartY = ev.y.toInt()
                // 外部可以通过反射修改
//                ViewCompat.setNestedScrollingEnabled(this, true)
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val x = ev.x.toInt()
                val y = ev.y.toInt()
                val deltaX = x - mStartX
                val deltaY = y - mStartY
                if (abs(deltaX) < abs(deltaY)) {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}