package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ListView
import kotlin.math.abs

/**
 * @author      sxczst
 * @date        2021/4/3 12:28
 */
class MyListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ListView(context, attrs, defStyleAttr) {

    private var mLastX: Int = 0

    private var mLastY: Int = 0

    /**
     * 内部拦截法
     */
//    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
//        val x = ev.x.toInt()
//        val y = ev.y.toInt()
//        when (ev.action) {
//            MotionEvent.ACTION_DOWN -> {
//                parent.requestDisallowInterceptTouchEvent(true)
//            }
//            MotionEvent.ACTION_MOVE -> {
//                val deltaX = x - mLastX
//                val deltaY = y - mLastY
//                if (abs(deltaX) > abs(deltaY)) {
//                    parent.requestDisallowInterceptTouchEvent(false)
//                }
//            }
//        }
//        mLastX = x
//        mLastY = y
//        return super.dispatchTouchEvent(ev)
//    }
}