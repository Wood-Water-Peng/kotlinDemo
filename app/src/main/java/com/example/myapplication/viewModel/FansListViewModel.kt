package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.AppExecutors
import com.example.myapplication.DataGenerator
import com.example.myapplication.beans.FanItemBean
import com.example.myapplication.repository.DataRepository

class FansListViewModel : ViewModel() {

    private val mRepository: DataRepository? = null
    private val fanItemBean by lazy {
        MutableLiveData<List<FanItemBean>>().also {
            loadUsers()
        }
    }

    fun getFanItemBean(): LiveData<List<FanItemBean>> {
        return fanItemBean;
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
        AppExecutors().networkIO.execute {

            val generateProducts = DataGenerator.generateProducts()
            AppExecutors().mainIO.execute {
                fanItemBean.value = generateProducts
            }
        }
//       = DataGenerator.generateProducts()
    }


}




