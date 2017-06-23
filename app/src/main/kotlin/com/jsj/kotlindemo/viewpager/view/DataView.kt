package com.jsj.kotlindemo.viewpager.view

import com.jsj.kotlindemo.net.ForecastBean

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface DataView {

    fun setData(data: List<ForecastBean>);

    fun showLoading();

    fun onFailed(reason: String, code: Int);
}