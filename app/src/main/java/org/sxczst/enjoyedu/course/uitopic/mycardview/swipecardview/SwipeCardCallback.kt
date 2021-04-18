package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter.UniversalAdapter
import kotlin.math.sqrt

/**
 * @author      sxczst
 * @date        2021/4/18 17:21
 */
class SwipeCardCallback(
    var adapter: UniversalAdapter<SwipeCardBean>,
    var mDatas: ArrayList<SwipeCardBean>
) : ItemTouchHelper.SimpleCallback(0, 15) {

    /**
     * drag
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = false


    /**
     * item 划出去后的回调
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // 删除数据
        val swipeCardBean = mDatas.removeAt(viewHolder.layoutPosition)
        // 放回到第一个
        mDatas.add(0, swipeCardBean)
        adapter.notifyDataSetChanged()
    }

    /**
     * onDraw
     */
    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        val maxDistance = (recyclerView.width * 0.5f)
        val distance = sqrt(dX * dX + dY * dY)
        var fraction = distance / maxDistance
        if (fraction > 1) {
            fraction = 1f
        }
        // 显示的个数 4 = CardConfig.MAX_SHOW_COUNT
        val itemCount = recyclerView.childCount
        for (i in 0 until itemCount) {
            val view = recyclerView.getChildAt(i)

            val level = itemCount - i - 1

            if (level > 0) {
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    view.translationY =
                        CardConfig.TRANS_Y_GAP * level - fraction * CardConfig.TRANS_Y_GAP
                    view.scaleX = 1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP
                    view.scaleY = 1 - CardConfig.SCALE_GAP * level + fraction * CardConfig.SCALE_GAP
                }
            }
        }
    }

    /**
     * 回弹时间
     */
    override fun getAnimationDuration(
        recyclerView: RecyclerView,
        animationType: Int,
        animateDx: Float,
        animateDy: Float
    ): Long {
        return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy)
    }

    /**
     * 划多少算是划出去
     */
    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder) = .2f
}