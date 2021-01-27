package com.example.myapplication.beans

class FanItemBean {
    var fanId: Int = -1;
    var portraitUrl: String = "";
    open var name: String? = "";
    var fansNum: Int = 0;
    open var description: String? = "";

    //0-未关注 1-已关注 2-相互关注
    var focusState: Int = 0;
}