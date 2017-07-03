package com.jsj.kotlindemo.viewpager.base

import android.app.Application

/**
 *
 * @author jsj
 * @since 17/6/27
 */
class MyApplication : Application() {

    companion object {
        private var instance: Application? = null;
        fun instance() = instance;
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}