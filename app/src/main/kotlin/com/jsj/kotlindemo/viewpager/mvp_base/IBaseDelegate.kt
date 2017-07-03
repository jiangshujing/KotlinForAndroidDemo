package com.jsj.kotlindemo.viewpager.mvp_base

/**
 * persenter和activity绑定
 * @param <V>
 * *
 * @param <P>
</P></V> */
interface IBaseDelegate<V : IBaseView, out P : IBasePresenter<V>> {

    /**
     * 初始化presenter
     */
    fun createPresenter(): P

    /**
     * 获取presenter
     */
    val presenter: P?

}