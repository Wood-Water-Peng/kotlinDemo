package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.beans.FanItemBean


@Dao
interface FanItemDao {
//    @Query("SELECT * FROM fansList")
//    fun loadAllProducts(): LiveData<List<FanItemBean?>?>?
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(fanList: List<FanItemBean?>?)
//
//    @Query("select * from fansList where fanId = :fanId")
//    fun loadProduct(fanId: Int): LiveData<FanItemBean?>?
//
//    @Query("select * from fansList where fanId = :fanId")
//    fun loadProductSync(fanId: Int): FanItemBean?
//
//    @Query(
//        "SELECT fansList.* FROM fansList JOIN productsFts ON (products.id = productsFts.rowid) "
//                + "WHERE productsFts MATCH :query"
//    )
//    fun searchAllProducts(query: String?): LiveData<List<FanItemBean?>?>?
}