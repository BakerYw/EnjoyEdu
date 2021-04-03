package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.scrollviewclash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R

/**
 * @author      sxczst
 * @date        2021/4/3 13:19
 */
class ScrollViewClashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_framework_topic_dispatch_scroll_view_clash,
            container,
            false
        )
    }
}