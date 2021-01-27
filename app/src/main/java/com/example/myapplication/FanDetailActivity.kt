package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.beans.FanDetailBean

class FanDetailActivity : AppCompatActivity() {
    var detailBean: FanDetailBean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_detail);
        detailBean = intent.getParcelableExtra("detail")

        var name: TextView = findViewById(R.id.activity_fan_detail_name)
        name.text = detailBean?.name

        var icon: ImageView = findViewById(R.id.activity_fan_detail_iv_back)
        icon.setOnClickListener { finish() }
    }
}