package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/5/27
 */
class UserNew(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(""" Address was changed for $name : "$field" -> "$value".""".trimIndent())
            field = value
        }

}