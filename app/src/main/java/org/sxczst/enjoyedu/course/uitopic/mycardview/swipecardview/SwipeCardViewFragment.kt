package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter.UniversalAdapter
import org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview.adapter.ViewHolder
import org.sxczst.enjoyedu.databinding.FragmentUiTopicSwipeCardViewBinding

/**
 * @author      sxczst
 * @date        2021/4/17 11:31
 */
class SwipeCardViewFragment : Fragment() {

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
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        binding.rv.adapter = object : UniversalAdapter<SwipeCardBean>(
            requireContext(),
            SwipeCardBean.initData(),
            R.layout.item_ui_topic_swipe_card_view
        ) {
            override fun convert(viewHolder: ViewHolder, data: SwipeCardBean) {
            }
        }
        return binding.root
    }
}