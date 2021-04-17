package org.sxczst.enjoyedu.course.uitopic.mycardview.swipecardview

/**
 * @author      sxczst
 * @date        2021/4/17 12:01
 */
data class SwipeCardBean(
    var postition: Int,
    var url: String,
    var name: String,
) {
    companion object {
        fun initData(): ArrayList<SwipeCardBean> {
            val list = arrayListOf<SwipeCardBean>()
            for (i in 0..9) {
                // TODO: 2021/4/17 URL
                list + SwipeCardBean(i, "", "Name$i")
            }
            return list
        }
    }
}