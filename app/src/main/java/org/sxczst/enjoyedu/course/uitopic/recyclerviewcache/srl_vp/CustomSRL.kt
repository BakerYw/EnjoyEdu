package org.sxczst.enjoyedu.course.uitopic.recyclerviewcache.srl_vp

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * @author      sxczst
 * @date        2021/4/12 20:12
 */
class CustomSRL : SwipeRefreshLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    override fun requestDisallowInterceptTouchEvent(b: Boolean) {
        val clazz = ViewGroup::class.java
        try {
            val mGroupFlagsField = clazz.getDeclaredField("mGroupFlags")
            mGroupFlagsField.isAccessible = true
            if (b) {
                mGroupFlagsField.set(this, 2900051)
            } else {
                mGroupFlagsField.set(this, 2245715)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev)
            return false
        }
        return true
    }
}