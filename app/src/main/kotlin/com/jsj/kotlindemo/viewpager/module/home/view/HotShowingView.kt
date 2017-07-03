package com.jsj.kotlindemo.viewpager.module.home.view

import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.mvp_base.IBaseView

/**
 *
 * @author jsj
 * @since 17/6/30
 */

interface HotShowingView : IBaseView {

    /**
     * 获取数据成功
     */
    fun onSuccess(date: Bean?)

}