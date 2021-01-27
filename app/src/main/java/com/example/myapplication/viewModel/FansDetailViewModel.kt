package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.beans.FanDetailBean
import com.example.myapplication.beans.FanItemBean
import kotlin.reflect.KProperty

class FansDetailViewModel : ViewModel() {


    private val fanItemBean by lazy {
       MutableLiveData<FanDetailBean>()
    }


}





