package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/5/27
 */
open class User(var id: Int, val name: String) {
//    var id: Int = 0
//    //        private set
//    val name: String = null!!

    val address: String = null!!
    open fun study() {
        println("User -> study");
    }
}