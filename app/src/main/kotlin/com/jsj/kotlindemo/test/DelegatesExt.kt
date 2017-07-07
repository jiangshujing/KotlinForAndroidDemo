package com.jsj.kotlindemo.test

import kotlin.properties.ReadWriteProperty

/**
 *
 * @author jsj
 * @since 17/7/7
 */
object DelegatesExt {

    public fun <T: Any> notNullSingleValue():ReadWriteProperty<Any?,T> = NotNullSingleValueVar()

}