package com.jsj.kotlindemo.test

import kotlin.reflect.KProperty

/**
 *
 * @author jsj
 * @since 17/6/28
 */
class Delegate {
    private var message = "Default Message";

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "${prop.name} = $message from $thisRef"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        message = value
    }
}