package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/8/14
 */
interface Clickable {
    var clicked: Boolean;

    fun click()
    fun showOff() = println("showOff")
    fun hideOff() = println("hideOff")
}