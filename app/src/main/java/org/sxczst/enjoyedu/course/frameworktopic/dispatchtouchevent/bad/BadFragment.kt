package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.FragmentFrameworkTopicDispatchBadBinding

/**
 * @author      sxczst
 * @date        2021/4/3 12:43
 */
class BadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFrameworkTopicDispatchBadBinding>(
            inflater,
            R.layout.fragment_framework_topic_dispatch_bad,
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