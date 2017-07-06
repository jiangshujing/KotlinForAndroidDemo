package com.jsj.kotlindemo.viewpager.module.home.bean

import org.greenrobot.greendao.annotation.Entity

/**
 *
 * @author jsj
 * @since 17/6/12
 */
@Entity
data class ForecastResultBean(var data: String, var status: Int,var message : String) {




}