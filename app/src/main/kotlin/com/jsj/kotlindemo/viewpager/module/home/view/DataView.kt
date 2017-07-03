package com.jsj.kotlindemo.viewpager.module.home.view

import com.jsj.kotlindemo.viewpager.module.home.bean.Bean

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface DataView {

    fun setData(data: Bean?);

    fun showLoading();

    fun onFailed(reason: String, code: Int);
}