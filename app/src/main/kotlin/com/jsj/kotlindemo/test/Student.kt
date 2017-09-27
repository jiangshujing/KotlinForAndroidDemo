package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/5/27
 */
/**
 * 子类继承User类
 */
class Student(id: Int, name: String) : User(id, name), Reading {

    override fun study() {
    }

    inner class Boy(){

        fun get(){
            //内部类引用外部类对象
            this@Student.study();
        }
    }
}