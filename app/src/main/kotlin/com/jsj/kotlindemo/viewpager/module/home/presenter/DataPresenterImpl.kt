package com.jsj.kotlindemo.viewpager.module.home.presenter

import android.util.Log
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.model.DataModel
import com.jsj.kotlindemo.viewpager.module.home.model.DataModelImpl
import com.jsj.kotlindemo.viewpager.module.home.view.DataView

/**
 *
 * @author jsj
 * @since 17/6/12
 */
class DataPresenterImpl constructor(val mView: DataView) : DataPresenter, DataModel.DataListener {

    val mModel: DataModel = DataModelImpl(this)

    init {
        Log.d("init ===== ", "")
        println("init ＝＝＝＝")
//        mModel = DataModelImpl(this)
    }


    override fun onSucceed(date: Bean?) {
        mView.setData(date)
    }

    override fun onFailed(reason: String) {
        println("onFailed ＝＝＝＝")
        mView.onFailed(reason,-1)
    }

    override fun showLoading() {
        mView.showLoading()
    }

    override fun getData(page: Int, type: String) {
        mModel.getData(page, type)
//                .observeOn(AndroidSchedulers.mainThread());
    }
}