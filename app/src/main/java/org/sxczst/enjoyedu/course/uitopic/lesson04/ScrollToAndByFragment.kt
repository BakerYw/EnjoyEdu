package org.sxczst.enjoyedu.course.uitopic.lesson04

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.sxczst.enjoyedu.R
import org.sxczst.enjoyedu.databinding.FragmentUiTopicScrollToAndByLayoutBinding

/**
 * @author      sxczst
 * @date        2021/4/19 20:54
 */
class ScrollToAndByFragment : Fragment() {

    /**
     * todo 添加滑动效果的几种方式
     * 1. 通过 View 的 ScrollBy 和 ScrollTo 方法来实现滑动
     * 2. 通过动画给 View 添加位移效果来实现滑动 (补间动画)
     * 3. 通过改变 View 的 layoutParams 让 View 重新布局从而实现滑动
     *
     * todo 事件的分发流程
     * inputManager windowManager Activity.dispatchTouchEvent() View
     *
     * todo 事件的类型
     * MotionEvent.ACTION_DOWN 表示用户开始触摸
     * MotionEvent.ACTION_MOVE 表示用户在移动手指
     * MotionEvent.ACTION_UP 表示用户抬起了手指
     * MotionEvent.ACTION_CANCEL 表示手势被取消了
     *
     * MotionEvent.ACTION_OUTSIDE 表示用户触摸超出了正常的 UI 边界
     *
     * todo 事件分发四个重要方法  面试重点
     * dispatchTouchEvent
     * onInterceptTouchEvent
     * onTouchEvent
     * setOnTouchListener
     *
     * todo 事件的记忆机制
     * 含义：窗口内的某个 View 消费了事件 (onTouchEvent 返回 true)，
     * 则后续事件会直接发给此 View 的 onTouchEvent，
     * 不会再经过其他 View 的 onTouchEvent。
     *
     * 原理：路径记忆是用 分层记忆 实现的。每个 ViewGroup 都是分发的关键节点，
     * 其维护一个 TouchTarget 链表、记录哪个子 View 消费该事件。
     * 上层只关注其直接子节点。
     *
     * todo 事件的截获机制
     * onInterceptTouchEvent
     * 两种情况：
     * ACTION_DOWN 事件一定可截获
     * 非 ACTION_DOWN 事件，若子类消费了事件，且自身标志位允许截获，则可截获。
     *
     * todo 事件的分裂机制
     * 含义：当某个 View 消费一次 ACTION_DOWN 事件后，后续点击到其旁系 View 的多指触摸事件
     * 将被分裂为单独的 ACTION_DOWN 事件，且其旁系 View 可消费、记忆此单独事件。
     *
     * Android 3.0 以上默认开启此机制，可以在主题配置 Activity 和 Window 关闭此功能
     *
     * todo 作业
     * FlowLayout: Padding Gravity
     * 温习 事件分发
     *
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentUiTopicScrollToAndByLayoutBinding>(
            inflater,
            R.layout.fragment_ui_topic_scroll_to_and_by_layout,
            container,
            false
        )
        val root = binding.root
        binding.btnScrollTo.setOnClickListener {
            Log.i(TAG, "scrollTo: 移动前: scrollX: ${root.scrollX},scrollY: ${root.scrollY}")
            root.scrollTo(50, 50)
            Log.i(TAG, "scrollTo: 移动后: scrollX: ${root.scrollX},scrollY: ${root.scrollY}")
        }
        binding.btnScrollBy.setOnClickListener {
            Log.i(TAG, "scrollBy: 移动前: scrollX: ${root.scrollX},scrollY: ${root.scrollY}")
            root.scrollBy(50, 50)
            Log.i(TAG, "scrollBy: 移动后: scrollX: ${root.scrollX},scrollY: ${root.scrollY}")
        }
        return root
    }

    companion object {
        private const val TAG = "ScrollToAndByFragment"
    }
}