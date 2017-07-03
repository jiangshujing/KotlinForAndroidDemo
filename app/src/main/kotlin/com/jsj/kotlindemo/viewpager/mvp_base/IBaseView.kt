package com.jsj.kotlindemo.viewpager.mvp_base

/**
 * @author jsj
 * *
 * @since 17/5/10
 */

interface IBaseView {

    /**
     * 显示加载
     */
    fun showLoading()

    /**
     * 失败

     * @param reason
     */
    fun onFailed(reason: String, code: Int)
}
