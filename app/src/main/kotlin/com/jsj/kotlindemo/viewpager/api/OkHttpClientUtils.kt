package com.jsj.kotlindemo.viewpager.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


/**
 *
 * @author jsj
 * @since 17/6/26
 */
class OkHttpClientUtils {

    //类似于java中的静态方法，可以只用类名直接引用
    companion object {
        fun getOkHttpClient(): OkHttpClient {
            //日志显示级别
            val level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("OkHttp====", "Message:" + message) })
            loggingInterceptor.setLevel(level)
            //定制OkHttp
            val httpClientBuilder = OkHttpClient.Builder()
            //OkHttp进行添加拦截器loggingInterceptor
            httpClientBuilder.addInterceptor(loggingInterceptor)
            return httpClientBuilder.build()
        }
    }
}