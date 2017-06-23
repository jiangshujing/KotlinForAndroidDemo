package com.jsj.kotlindemo.viewpager.presenter

import android.util.Log
import com.jsj.kotlindemo.viewpager.model.DataModel
import com.jsj.kotlindemo.viewpager.model.DataModelImpl
import com.jsj.kotlindemo.viewpager.view.DataView

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


    override fun onSucceed() {
        println("onSucceed ＝＝＝＝")
    }

    override fun onFailed(reason: String) {
        println("onFailed ＝＝＝＝")
    }

    override fun showLoading() {
        println("showLoading ＝＝＝＝")
    }

    override fun getData(page: Int, type: String) {
//        mModel.getData(page, type)
//                .observeOn(AndroidSchedulers.mainThread());
    }
}