package com.jsj.kotlindemo.test

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @author jsj
 * @since 17/7/7
 * 自定义委托，我们自己的委托必须要实现kotlin库提供的接口 ReadOnlyProperty 和 ReadWriteProperty
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null


    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        return value ?: throw IllegalAccessException("not initialized")
    }

    /**
     * 只能初始化一次，二次初始化会抛出异常
     */
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null)
            value
        else
            throw IllegalAccessException("只能赋值一次")
    }
}