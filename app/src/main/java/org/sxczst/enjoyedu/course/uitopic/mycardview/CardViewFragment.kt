package org.sxczst.enjoyedu.course.uitopic.mycardview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.FragmentUiTopicCardViewBinding

/**
 * @author      sxczst
 * @date        2021/4/16 20:53
 */
class CardViewFragment : Fragment() {

    /**
     * todo CardView 不同的效果
     * CardViewImpl -> 21 17
     * CardViewImpl.initialize()
     * 17 -> RoundRectDrawableWithShadow
     * CardViewDelegate.setCardBackground()
     * CardViewImpl.updatePadding()
     * RoundRectDrawableWithShadow.getMaxShadowAndCornerPadding()
     * RoundRectDrawableWithShadow.getPadding()
     * RoundRectDrawableWithShadow.calculateVerticalPadding() & calculateHorizontalPadding() -> cornerRadius
     *
     * todo 圆角问题解决方案
     * app:cardPreventCornerOverlap = false <--> addPaddingForCorners
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentUiTopicCardViewBinding>(
            inflater,
            R.layout.fragment_ui_topic_card_view,
            container,
            false
        )
        return binding.root
    }
}