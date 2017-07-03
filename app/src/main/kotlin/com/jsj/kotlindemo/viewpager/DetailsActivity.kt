package com.jsj.kotlindemo.viewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jsj.kotlindemo.R

class DetailsActivity : AppCompatActivity() {

    companion object {
        var id: Int = 0;
        var name: String? = null;

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
