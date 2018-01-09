@file:JvmName("StringFunctions")

package com.jsj.kotlindemo.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.lastChar
import com.jsj.kotlindemo.viewpager.myJoinToString

fun joinToString() {
    println("顶部函数")
}


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        "kotlin".lastChar()
        val list = listOf(1, 2, 3)
        list.myJoinToString(" ")

        println("Hello,${"world"}!")
        val rectangle = Rectangle(3, 4);

        for (i in 1..10) {
            print("$i")
        }

        "c" in setOf("a", "b", "c")

//        listOf("A", "B")
//        arrayListOf(1, 2, 3, 4)
//        mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
//        hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
//        setOf("A", "B")
//        hashSetOf(1, 7, 53)

        val lists = arrayOf("a", "b", "c")
        variable(*lists);

        val user: User = User(1,"name")
        val id = user.id
        user.id = 1
        user.name

    }

//    class User(val id: Int, val name: String, val address: String) {}

    //局部函数
    fun saveUser(user: User) {
        fun validate(value: String, fieldName: String) {

            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id}:empty$fieldName")
            }
        }

        //调用局部函数验证特定字段
        validate(user.name, "Name")
        validate(user.address, "Address")
    }

    fun variable(vararg arrs: String) {
        for (str in arrs) {
            println("str == $str")
        }
    }

    fun getWarmth(color: Color) = when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }

    fun getWarmth1(color: Color) = when {
        (color == Color.RED || color == Color.ORANGE || color == Color.YELLOW) -> "warm"
        (color == Color.GREEN) -> "neutral"
        (color == Color.BLUE || color == Color.INDIGO || color == Color.VIOLET) -> "cold"

        else -> {
            throw Exception("other")
        }
    }
}
