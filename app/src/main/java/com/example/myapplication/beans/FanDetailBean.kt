package com.example.myapplication.beans

import android.os.Parcel
import android.os.Parcelable

class FanDetailBean() : Parcelable {

    var fanId: Int = -1;
    var portraitUrl: String = "";
    open var name: String? = "";
    var fansNum: Int = 0;
    open var description: String? = "";

    //0-未关注 1-已关注 2-相互关注
    var focusState: Int = 0;

    constructor(name: String) : this() {
        this.name = name
    }

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
    }


    companion object CREATOR : Parcelable.Creator<FanDetailBean> {
        override fun createFromParcel(parcel: Parcel): FanDetailBean {
            return FanDetailBean(parcel)
        }

        override fun newArray(size: Int): Array<FanDetailBean?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

}