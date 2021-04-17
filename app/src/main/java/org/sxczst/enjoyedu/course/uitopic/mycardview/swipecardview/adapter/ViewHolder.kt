package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author      sxczst
 * @date        2021/4/17 11:50
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun get(
            context: Context,
            view: View?,
            viewGroup: ViewGroup,
            @LayoutRes layoutId: Int
        ) = ViewHolder(view ?: LayoutInflater.from(context).inflate(layoutId, viewGroup, false))
    }
}