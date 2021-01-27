package com.example.myapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.beans.FanItemBean
import java.util.*


@Entity(tableName = "fansList")
data class FansItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "userid")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "username")
    val userName: String
) {

    var fanId: Int = -1;
    var portraitUrl: String = "";
    open var name: String? = "";
    var fansNum: Int = 0;
    open var description: String? = "";

    //0-未关注 1-已关注 2-相互关注
    var focusState: Int = 0;

}