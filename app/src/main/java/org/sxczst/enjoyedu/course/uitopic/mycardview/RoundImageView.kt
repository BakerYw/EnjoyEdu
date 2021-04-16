package org.sxczst.enjoyedu.course.uitopic.mycardview

import android.content.Context
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * @author      sxczst
 * @date        2021/4/16 21:38
 */
class RoundImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private var mBorderRadius = 20

    init {
        mBorderRadius = dip2px(context, mBorderRadius)
    }

    private fun dip2px(context: Context, dp: Int): Int {
        TODO("Not yet implemented")
    }
}