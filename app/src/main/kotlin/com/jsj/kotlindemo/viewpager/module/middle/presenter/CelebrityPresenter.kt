package com.jsj.kotlindemo.viewpager.module.home.presenter

import android.content.Context
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.model.CelebrityModel
import com.jsj.kotlindemo.viewpager.module.home.view.CelebrityView
import com.jsj.kotlindemo.viewpager.mvp_base.IBasePresenter

/**
 *
 * @author jsj
 * @since 17/6/30
 */
class CelebrityPresenter(context: Context, view: CelebrityView) : IBasePresenter<CelebrityView> {

    var mContext = context
    var mView = view
    var mModel: CelebrityModel? = null

    init {
        attachView(view)
        mModel = CelebrityModel(mContext, this@CelebrityPresenter)
    }

    override fun attachView(view: CelebrityView?) {
        mView = view!!
    }

    override fun detachView() {
        mView = null!!
    }

    fun onFailed(reason: String, code: Int) {
        if (mView != null)
            mView.onFailed(reason, code)
    }

    fun showLoading() {
        if (mView != null)
            mView.showLoading()
    }

    fun onSuccess(data: Bean?){
        if (mView != null)
            mView.onSuccess(data)
    }

    fun getHotShowingListData(page: Int, count: Int) {
        mModel?.getCelebrityListData(page,count)
    }
}