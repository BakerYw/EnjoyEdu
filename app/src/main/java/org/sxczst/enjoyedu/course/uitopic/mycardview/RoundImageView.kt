package org.sxczst.enjoyedu.course.uitopic.mycardview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
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
        val density = context.resources.displayMetrics.density
        return (dp / density + 0.5f).toInt()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawable ?: return

        val sc =
            canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        // 画源图像，为一个圆角矩形
        canvas.drawRoundRect(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            mBorderRadius.toFloat(),
            mBorderRadius.toFloat(),
            mPaint
        )
        // 设置混合模式
        mPaint.xfermode = mXfermode
        // 画目标图像
        canvas.drawBitmap(drawableToBitmap(exChangeSize(drawable)), 0f, 0f, mPaint)
        // 还原混合模式
        mPaint.xfermode = null
        canvas.restoreToCount(sc)
    }

    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        TODO("Not yet implemented")
    }

    private fun exChangeSize(drawable: Drawable): Drawable {
        TODO("Not yet implemented")
    }
}