package com.jsj.kotlindemo.net

/**
 *
 * @author jsj
 * @since 17/6/12
 */
data class HttpResult<T>(var code: Int, var msg: String, var body: T) {}