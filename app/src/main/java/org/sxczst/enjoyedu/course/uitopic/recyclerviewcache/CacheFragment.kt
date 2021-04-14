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
    /**
     * todo RecyclerView 复用机制
     * MotionEvent.ACTION_MOVE
     * scrollByInternal()
     * scrollStep()
     * LayoutManager.scrollHorizontallyBy() / LayoutManager.scrollVerticallyBy()
     * LinearLayoutManager.scrollBy()
     * LinearLayoutManager.fill()
     * LinearLayoutManager.recycleByLayoutState()
     * LinearLayoutManager.layoutChunk() 复用机制
     * LayoutState.next()
     * getViewForPosition()
     * getViewForPosition()
     * tryGetViewHolderForPositionByDeadline() -> 四级缓存
     * 1. Recycler.getChangedScrapViewForPosition() -> ArrayList<ViewHolder> mChangedScrap
     * 2. Recycler.getScrapOrHiddenOrCachedHolderForPosition() -> ArrayList<ViewHolder> mAttachedScrap ; ArrayList<ViewHolder> mCachedViews
     * 3. Recycler.getScrapOrCachedViewForId()
     * 4. mViewCacheExtension
     * 5. getRecycledViewPool().getRecycledView() -> RecycledViewPool mRecyclerPool -> SparseArray<ScrapData> mScrap -> ArrayList<ViewHolder> mScrapHeap -> scrapHeap.remove()
     * 6. Adapter.createViewHolder()
     * tryBindViewHolderByDeadline() -> Adapter.bindViewHolder()
     */

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