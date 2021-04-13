package org.sxczst.enjoyedu.course.uitopic.recyclerviewcache

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.course.uitopic.recyclerviewcache.CustomAdapter.ViewHolder
import org.sxczst.enjoyedu.databinding.ItemUiTopicRecyclerviewCacheBinding

/**
 * @author      sxczst
 * @date        2021/4/13 20:07
 */
class CustomAdapter(
    var list: List<Int>? = listOf()
) : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(var binding: ItemUiTopicRecyclerviewCacheBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemUiTopicRecyclerviewCacheBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_ui_topic_recyclerview_cache,
            parent,
            false
        )
        Log.i(TAG, "onCreateViewHolder: $itemCount")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list?.size?.let { size ->
            if (size > 0) list?.get(position % size)?.let {
                holder.binding.iv.setImageResource(it)
            } else {
                holder.binding.iv.setImageResource(R.mipmap.enjoy_edu_logo)
            }
        }
        Log.i(TAG, "onBindViewHolder: $position")
    }

    override fun getItemCount() = if (list == null) 0 else 3000

    companion object {
        private const val TAG = "CustomAdapter"
    }
}