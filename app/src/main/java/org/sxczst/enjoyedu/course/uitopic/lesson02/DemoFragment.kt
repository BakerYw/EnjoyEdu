package org.sxczst.enjoyedu.course.uitopic.lesson02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R

/**
 * @author      sxczst
 * @date        2021/4/1 19:40
 */
class DemoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_uitopic_lesson02, container, false)
    }
}