package com.jsj.kotlindemo.test

import android.util.Log
import kotlin.properties.Delegates

/**
 *
 * @author jsj
 * @since 17/6/28
 * 存在属性委托的类
 */
class Example {
    var msg: String by Delegates.observable("init value") {
        prop, old, new ->
        if (old != new) {
            Log.e("", "old == $old new == $new")
        }
    }
}