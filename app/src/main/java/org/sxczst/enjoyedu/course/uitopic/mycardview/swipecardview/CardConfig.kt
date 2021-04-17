package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

import android.content.Context
import android.util.TypedValue

/**
 * @author      sxczst
 * @date        2021/4/17 11:45
 */
object CardConfig {
    var MAX_SHOW_COUNT = 0
    var SCALE_GAP = 0f
    var TRANS_Y_GAP = 0

    fun initConfig(context: Context) {
        MAX_SHOW_COUNT = 4
        SCALE_GAP = 0.05f
        TRANS_Y_GAP = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            15f,
            context.resources.displayMetrics
        ).toInt()
    }
}