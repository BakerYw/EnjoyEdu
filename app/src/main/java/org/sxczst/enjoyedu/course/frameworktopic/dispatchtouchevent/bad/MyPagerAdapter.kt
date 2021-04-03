package org.sxczst.enjoyedu.course.frameworktopic.dispatchtouchevent.bad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.ItemListFrameworkTopicDispatchBadBinding

/**
 * @author      sxczst
 * @date        2021/4/3 12:30
 */
class MyPagerAdapter(
    private val context: Context,
    private val data: List<Map<String, Int>>
) : PagerAdapter() {

    override fun getCount() = 5

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<ItemListFrameworkTopicDispatchBadBinding>(
            LayoutInflater.from(context),
            R.layout.item_list_framework_topic_dispatch_bad,
            container,
            false
        )
        binding.list.adapter =
            SimpleAdapter(
                context,
                data,
                R.layout.item_base_framework_topic_dispatch_bad,
                arrayOf("key"),
                intArrayOf(R.id.iv)
            )
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` === view
    }
}