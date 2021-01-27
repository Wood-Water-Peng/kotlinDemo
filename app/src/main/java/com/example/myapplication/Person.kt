package com.example.myapplication

import android.app.Application
import android.content.Context
import android.view.View
import java.util.jar.Attributes

open class Person(var name: String? = "张三") {
    constructor(name: String, age: String) : this(name) {

    }

}

class Man(var age: Int) : Person() {
    constructor(name: String, age: Int) : this(age) {

    }
}

class MyView(ctx: Context) : View(ctx) {
    init {
        if (ctx is Application) {
            throw IllegalArgumentException("ctx can not be Application!")
        }
    }

    var first = "First property";

    constructor(ctx: Context, att: Attributes) : this(ctx) {
        if (att == null) {
            throw IllegalArgumentException("att can not be Application!")
        }
    }
}

