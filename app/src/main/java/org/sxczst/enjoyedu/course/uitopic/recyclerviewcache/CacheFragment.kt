package org.sxczst.enjoyedu.course.uitopic.recyclerviewcache

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.FragmentUiTopicRecyclerviewCacheBinding

/**
 * @author      sxczst
 * @date        2021/4/13 20:28
 */
class CacheFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUiTopicRecyclerviewCacheBinding>(
            inflater,
            R.layout.fragment_ui_topic_recyclerview_cache,
            container,
            false
        )
        binding.rv.adapter = CustomAdapter()
        return binding.root
    }
}