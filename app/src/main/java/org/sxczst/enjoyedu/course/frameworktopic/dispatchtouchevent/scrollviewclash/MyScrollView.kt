package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.scrollviewclash

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView
import kotlin.math.abs

/**
 * @author      sxczst
 * @date        2021/4/7 21:00
 */
class MyScrollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ScrollView(context, attrs, defStyleAttr) {

    private var mLastX: Int = 0

    private var mLastY: Int = 0

    /**
     * 内部拦截法
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val x = ev.x.toInt()
        val y = ev.y.toInt()
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX = x - mLastX
                val deltaY = y - mLastY
                // TODO: 2021/4/7  
                if (abs(deltaX) > abs(deltaY)) {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        mLastX = x
        mLastY = y
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 外部拦截法
     */
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
//        val x = ev.x.toInt()
//        val y = ev.y.toInt()
//        when (ev.action) {
//            MotionEvent.ACTION_DOWN -> {
//                mLastX = ev.x.toInt()
//                mLastY = ev.y.toInt()
//            }
//            MotionEvent.ACTION_MOVE -> {
//                val deltaX = x - mLastX
//                val deltaY = y - mLastY
//                if (abs(deltaX) > abs(deltaY)) {
//                    return true
//                }
//            }
//        }
        return super.onInterceptTouchEvent(ev)
    }
}