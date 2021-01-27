package com.example.myapplication

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class AppExecutors {
    var networkIO: ExecutorService = Executors.newFixedThreadPool(3);
    var mainIO: Executor = MainThreadExecutor()

    constructor()


    inner class MainThreadExecutor : Executor {
        private val mainThreadHandler: Handler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable?) {
            mainThreadHandler.post(command)
        }

    }
}