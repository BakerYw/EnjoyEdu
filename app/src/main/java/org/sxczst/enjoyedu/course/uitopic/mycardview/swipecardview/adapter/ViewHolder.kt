package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author      sxczst
 * @date        2021/4/17 11:50
 */
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setText(viewId: Int, text: CharSequence) {
        itemView.findViewById<TextView>(viewId).text = text
    }

    fun <T : View> getView(viewId: Int): T? = itemView.findViewById(viewId)

    companion object {
        fun get(
            context: Context,
            view: View?,
            viewGroup: ViewGroup,
            @LayoutRes layoutId: Int
        ) = ViewHolder(view ?: LayoutInflater.from(context).inflate(layoutId, viewGroup, false))
    }
}