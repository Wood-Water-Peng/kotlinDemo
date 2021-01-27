package com.example.myapplication.repository

import com.example.myapplication.db.AppDatabase

class DataRepository(database: AppDatabase?) {

    private var sInstance: DataRepository? = null

    fun getInstance(database: AppDatabase?): DataRepository? {
        if (sInstance == null) {
            synchronized(DataRepository::class.java) {
                if (sInstance == null) {
                    sInstance = DataRepository(database)
                }
            }
        }
        return sInstance
    }

}