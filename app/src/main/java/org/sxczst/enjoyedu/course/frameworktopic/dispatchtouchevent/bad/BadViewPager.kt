package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

/**
 * @author      sxczst
 * @date        2021/4/3 12:25
 */
class BadViewPager : ViewPager {

    private var mLastX: Int = 0

    private var mLastY: Int = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        // 内部拦截法
//        if (ev.action == MotionEvent.ACTION_DOWN) {
//            super.onInterceptTouchEvent(ev)
//            return false
//        }
//        return true

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
}