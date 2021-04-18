package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author      sxczst
 * @date        2021/4/18 16:39
 */
class SwipeCardLayoutManager : RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams() = RecyclerView.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        // super.onLayoutChildren(recycler, state)
        // 回收
        detachAndScrapAttachedViews(recycler)
        //
        val itemCount = itemCount
        val bottomPosition = if (itemCount < CardConfig.MAX_SHOW_COUNT) {
            0
        } else {
            itemCount - CardConfig.MAX_SHOW_COUNT
        }
        for (i in bottomPosition until itemCount) {
            // 复用
            val view = recycler.getViewForPosition(i)
            addView(view)
            // 测量
            measureChildWithMargins(view, 0, 0)
            // 获取间隙，求 padding 的总大小
            val widthSpace = width - getDecoratedMeasuredWidth(view)
            val heightSpace = height - getDecoratedMeasuredHeight(view)
            // 布局
            layoutDecoratedWithMargins(
                view,
                widthSpace / 2,
                heightSpace / 2,
                widthSpace / 2 + getDecoratedMeasuredWidth(view),
                heightSpace / 2 + getDecoratedMeasuredHeight(view)
            )
            // 平移缩放
            val level = itemCount - i - 1
            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    view.translationY = (CardConfig.TRANS_Y_GAP * level).toFloat()
                    view.scaleX = 1 - CardConfig.SCALE_GAP * level
                    view.scaleY = 1 - CardConfig.SCALE_GAP * level
                } else {
                    view.translationY = (CardConfig.TRANS_Y_GAP * (level - 1)).toFloat()
                    view.scaleX = 1 - CardConfig.SCALE_GAP * (level - 1)
                    view.scaleY = 1 - CardConfig.SCALE_GAP * (level - 1)
                }
            }
        }
    }
}