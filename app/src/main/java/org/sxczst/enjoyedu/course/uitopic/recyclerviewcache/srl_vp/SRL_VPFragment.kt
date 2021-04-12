package org.sxczst.enjoyedu.course.uitopic.recyclerviewcache.srl_vp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad.MyPagerAdapter
import org.sxczst.enjoyedu.databinding.FragmentUiTopicRecyclerviewCacheSrlVpBinding

/**
 * @author      sxczst
 * @date        2021/4/12 20:24
 */
class SRL_VPFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUiTopicRecyclerviewCacheSrlVpBinding>(
            inflater,
            R.layout.fragment_ui_topic_recyclerview_cache_srl_vp,
            container,
            false
        )

        val data = arrayListOf<Map<String, Int>>()

        for (i in 0 until 20) {
            val map = hashMapOf("key" to R.mipmap.enjoy_edu_logo)
            data.add(map)
        }

        binding.viewPager.adapter = MyPagerAdapter(requireContext(), data)
        return binding.root
    }
}