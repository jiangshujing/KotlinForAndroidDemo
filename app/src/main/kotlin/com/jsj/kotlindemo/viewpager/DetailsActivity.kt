package com.jsj.kotlindemo.viewpager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.test.joinToString

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }


fun String.lastChar(): Char = this.get(this.length - 1)

fun <T> Collection<T>.myJoinToString(separator: String = ",",
                                     prefix: String = "",
                                     postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

class DetailsActivity : AppCompatActivity() {

    companion object {
        var id: Int = 0;
        var name: String? = null;

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        joinToString()
        "kotlin".lastChar()
        val list = listOf(1, 2, 3)
        list.myJoinToString(" ")//以空格相隔
        "Kotlin".lastChar
    }


}
