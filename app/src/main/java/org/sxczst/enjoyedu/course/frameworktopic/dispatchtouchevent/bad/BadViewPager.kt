package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager

/**
 * @author      sxczst
 * @date        2021/4/3 12:25
 */
class BadViewPager : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

//    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        return false
//    }
}