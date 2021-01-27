package com.example.myapplication.utils

import android.content.res.Resources

class TSDKDensityUtils {
    //基友
    companion object {
        @JvmStatic
        fun dip2px(dip: Int): Int {
            val scale =
                Resources.getSystem().displayMetrics.density
            return (dip * scale + 0.5f).toInt()
        }
    }
}