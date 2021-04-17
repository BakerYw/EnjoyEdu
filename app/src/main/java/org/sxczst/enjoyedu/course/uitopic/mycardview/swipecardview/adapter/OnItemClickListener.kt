package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter

import android.view.View
import android.view.ViewGroup

/**
 * @author      sxczst
 * @date        2021/4/17 11:50
 */
interface OnItemClickListener {
    fun onItemClick(viewGroup: ViewGroup, view: View)
    fun onItemLongClick(view: View, position: Int): Boolean
}