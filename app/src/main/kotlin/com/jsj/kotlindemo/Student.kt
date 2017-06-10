package com.jsj.kotlindemo

/**
 *
 * @author jsj
 * @since 17/5/27
 */
/**
 * 子类继承User类
 */
class Student : User() ,Reading {

    override fun study() {
    }

    inner class Boy(){

        fun get(){
            //内部类引用外部类对象
            this@Student.study();
        }
    }
}