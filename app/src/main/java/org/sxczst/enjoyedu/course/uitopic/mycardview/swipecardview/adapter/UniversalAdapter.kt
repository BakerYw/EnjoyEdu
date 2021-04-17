package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * @author      sxczst
 * @date        2021/4/17 11:35
 */
abstract class UniversalAdapter<T>(
    val mContext: Context,
    val mDatas: List<T>,
    @LayoutRes val mLayoutId: Int
) : RecyclerView.Adapter<ViewHolder>() {

    private val mInflater = LayoutInflater.from(mContext)

    private lateinit var mRv: ViewGroup

    var mOnItemClickListener: OnItemClickListener? = null
        private set

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener): UniversalAdapter<T> {
        mOnItemClickListener = onItemClickListener
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId)
        if (!::mRv.isInitialized) mRv = parent
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setListener(position, holder)
        convert(holder, mDatas[position])
    }

    abstract fun convert(viewHolder: ViewHolder, data: T)

    private fun setListener(position: Int, holder: ViewHolder) {
        if (isEnabled(getItemViewType(position))) {
            holder.itemView.setOnClickListener { v ->
                mOnItemClickListener?.onItemClick(mRv, v)
            }
            holder.itemView.setOnLongClickListener { v ->
                mOnItemClickListener
                    ?.onItemLongClick(v, getPosition(holder))
                    ?: false
            }
        }
    }

    private fun isEnabled(viewType: Int): Boolean {
        TODO("Not yet implemented")
    }

    private fun getPosition(holder: ViewHolder): Int {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = mDatas.size
}