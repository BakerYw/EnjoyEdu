package org.sxczst.enjoyedu.course.uitopic.lesson03

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author      sxczst
 * @date        2021/4/20 19:49
 */
object Utils {
    fun dp2px(dp: Int) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()
}