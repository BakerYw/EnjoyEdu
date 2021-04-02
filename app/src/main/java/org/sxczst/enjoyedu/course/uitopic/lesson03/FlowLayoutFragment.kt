package org.sxczst.enjoyedu.course.uitopic.lesson03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R

/**
 * @author      sxczst
 * @date        2021/4/2 22:04
 */
class FlowLayoutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ui_topic_flow_layout, container, false)
    }
}