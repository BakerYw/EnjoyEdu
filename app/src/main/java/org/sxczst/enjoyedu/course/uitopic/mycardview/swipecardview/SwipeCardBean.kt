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
                list += SwipeCardBean(
                    i,
                    "http://img5.mtime.cn/pi/2020/02/03/102634.99979499_1000X1000.jpg",
                    "Name$i"
                )
            }
            return list
        }
    }
}