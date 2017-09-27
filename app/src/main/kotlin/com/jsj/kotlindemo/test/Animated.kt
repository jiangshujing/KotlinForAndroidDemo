package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/8/14
 */
abstract class Animated {
    abstract fun animated()//此函数为抽象函数，必须被子类重写
    //抽象类中的非抽象函数并不是默认open的，但是可以标注为open
    open fun stopAnimating() {}
    fun animateTwice() {}
}