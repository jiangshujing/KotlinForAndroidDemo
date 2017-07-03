package com.jsj.kotlindemo.viewpager.module.home.model

import com.jsj.kotlindemo.viewpager.module.home.bean.Bean

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface DataModel {

    fun getData(page: Int, type: String)

    interface DataListener {

        fun onSucceed(date: Bean?)

        fun onFailed(reason: String)

        fun showLoading()
    }
}