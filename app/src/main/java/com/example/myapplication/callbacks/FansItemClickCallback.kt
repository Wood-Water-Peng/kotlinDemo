package com.example.myapplication.callbacks

import com.example.myapplication.beans.FanItemBean
import java.text.FieldPosition

interface FansItemClickCallback {
    fun onFanClicked(position: Int, bean: FanItemBean)

    fun onFanFocusClicked(position: Int, bean: FanItemBean)
}