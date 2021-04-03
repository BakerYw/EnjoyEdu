package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.FragmentFrameworkTopicDispatchBinding

/**
 * @author      sxczst
 * @date        2021/4/3 11:51
 *
 * todo 寻找滑动冲突的事件跟源
 *
 * todo 事件处理
 * View -> dispatchTouchEvent -> onTouchEvent -> performClickInternal -> performClick
 */
class DispatchFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFrameworkTopicDispatchBinding>(
            inflater,
            R.layout.fragment_framework_topic_dispatch,
            container,
            false
        )
        binding.btnClick.setOnClickListener {
            Log.i(TAG, "onClick")
        }
        binding.btnClick.setOnTouchListener { v, event ->
            Log.i(TAG, "onTouch:${event.action}")
            true
        }
        return binding.root
    }

    companion object {
        private const val TAG = "DispatchFragment"
    }
}