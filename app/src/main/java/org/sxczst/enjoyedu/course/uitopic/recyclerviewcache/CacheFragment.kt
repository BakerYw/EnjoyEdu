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
     * LinearLayoutManager.recycleByLayoutState() 回收机制
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
     *
     * todo RecyclerView 回收机制
     * LinearLayoutManager.fill()
     * LinearLayoutManager.recycleByLayoutState()
     * recycleViewsFromEnd() / recycleViewsFromStart()
     * recycleChildren()
     * removeAndRecycleViewAt()
     * Recycler.recycleView()
     * recycleViewHolderInternal() -> 回收的主要方法。ArrayList<ViewHolder> mCachedViews 先进先出，mViewCacheMax = DEFAULT_CACHE_SIZE
     * recycleCachedViewAt()
     * addViewHolderToRecycledViewPool()
     * putRecycledView() -> DEFAULT_MAX_SCRAP = 5
     * ViewHolder.resetInternal()
     *
     * todo RecyclerView.onLayout() 角度分析 回收复用机制
     * onLayout()
     * dispatchLayout()
     * dispatchLayoutStep1()，dispatchLayoutStep2()，dispatchLayoutStep3()
     * LayoutManager.onLayoutChildren()
     * detachAndScrapAttachedViews()
     * scrapOrRecycleView()
     * - Recycler.scrapView() -> mAttachedScrap.add(holder)
     * - recycleViewHolderInternal()
     *
     * todo 默认缓存大小 5n+2
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