package com.example.myapplication

import com.example.myapplication.beans.FanItemBean
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class DataGenerator {

    companion object {
        private val FIRST = arrayOf(
            "Special edition", "New", "Cheap", "Quality", "Used"
        )
        private val SECOND = arrayOf(
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle"
        )
        private val DESCRIPTION = arrayOf(
            "is finally here", "is recommended by Stan S. Stanman",
            "is the best sold product on Mêlée Island", "is \uD83D\uDCAF", "is ❤️", "is fine"
        )

        fun generateProducts(): List<FanItemBean>? {
            val products: MutableList<FanItemBean> =
                ArrayList(FIRST.size * SECOND.size)
            var random = Random(1)
            for (i in FIRST.indices) {
                for (j in SECOND.indices) {
                    val fanItemBean = FanItemBean()
                    fanItemBean.name = (FIRST[i] + " " + SECOND[j])
                    fanItemBean.description = (fanItemBean.name + " " + DESCRIPTION[j])
                    fanItemBean.fanId = (FIRST.size * i + j + 1)
                    fanItemBean.fansNum = random.nextInt(100)
                    products.add(fanItemBean)
                }
            }
            return products
        }
    }
}