package com.jsj.kotlindemo.viewpager.model

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface DataModel {

    fun getData(page: Int, type: String)

    interface DataListener {

        fun onSucceed()

        fun onFailed(reason: String)

        fun showLoading()
    }
}