package com.example.myapplication

import android.content.Context

class Singleton private constructor(context: Context) {
    var mContext: Context = context;

    companion object {
        fun getInstance(context: Context): Singleton {
            return Singleton(context)
        }
    }
}