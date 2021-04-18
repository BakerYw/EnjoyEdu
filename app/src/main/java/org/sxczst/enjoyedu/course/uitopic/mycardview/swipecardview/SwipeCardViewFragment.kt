package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import coil.load
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter.UniversalAdapter
import org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter.ViewHolder
import org.sxczst.enjoyedu.databinding.FragmentUiTopicSwipeCardViewBinding

/**
 * @author      sxczst
 * @date        2021/4/17 11:31
 */
class SwipeCardViewFragment : Fragment() {

    private val mDatas = SwipeCardBean.initData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentUiTopicSwipeCardViewBinding>(
            inflater,
            R.layout.fragment_ui_topic_swipe_card_view,
            container,
            false
        )
        binding.rv.layoutManager = SwipeCardLayoutManager()

        val adapter = object : UniversalAdapter<SwipeCardBean>(
            requireContext(),
            mDatas,
            R.layout.item_ui_topic_swipe_card_view
        ) {
            override fun convert(viewHolder: ViewHolder, data: SwipeCardBean) {
                viewHolder.setText(R.id.tv_name, data.name)
                viewHolder.setText(R.id.tv_percent, "${data.postition}/${mDatas.size}")
                viewHolder.getView<AppCompatImageView>(R.id.iv)?.load(data.url)
            }
        }
        binding.rv.adapter = adapter
        // 滑动
        ItemTouchHelper(SwipeCardCallback(adapter, mDatas)).attachToRecyclerView(binding.rv)
        CardConfig.initConfig(requireContext())
        return binding.root
    }
}