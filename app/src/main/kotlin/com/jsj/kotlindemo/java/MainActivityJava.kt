package com.jsj.kotlindemo.java

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.jsj.kotlindemo.R

/**
 * @author jsj
 * *
 * @since 17/5/20
 */

class MainActivityJava : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById(R.id.tv_name) as TextView
        textView.text = "你好"

        val array = arrayOf(1, 2, 3)
    }

    /**
     * 设置年龄
     * @return
     */
    fun setAge(age: Int): Int {

        return age
    }
}
