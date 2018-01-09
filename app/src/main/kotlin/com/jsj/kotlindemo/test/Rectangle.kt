package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/8/10
 */
class Rectangle(val width: Int, val height: Int) {

    /**
     * 不可变变量 只有get 没有set
     */
    val isSquare: Boolean
        get() = width == height


    /**
     * 可变变量 get set 方法都有
     */
    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

//    var heiht: Float = 145.4f
//        private set
}