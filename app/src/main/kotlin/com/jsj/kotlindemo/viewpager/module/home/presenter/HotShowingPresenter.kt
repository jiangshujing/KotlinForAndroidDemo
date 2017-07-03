package com.jsj.kotlindemo.viewpager.module.home.presenter

import android.content.Context
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.model.HotShowingModel
import com.jsj.kotlindemo.viewpager.module.home.view.HotShowingView
import com.jsj.kotlindemo.viewpager.mvp_base.IBasePresenter

/**
 *
 * @author jsj
 * @since 17/6/30
 */
class HotShowingPresenter(context: Context, view: HotShowingView?) : IBasePresenter<HotShowingView> {

    var mContext = context
    var mView = view
    var mModel: HotShowingModel? = null

    init {
        attachView(view)
        mModel = HotShowingModel(mContext, this@HotShowingPresenter)
    }

    override fun attachView(view: HotShowingView?) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

    fun onFailed(reason: String, code: Int) {
        if (mView != null)
            mView?.onFailed(reason, code)
    }

    fun showLoading() {
        if (mView != null)
            mView?.showLoading()
    }

    fun onSuccess(data: Bean?) {
        if (mView != null)
            mView?.onSuccess(data)
    }

    fun getHotShowingListData(page: Int, count: Int) {
        mModel?.getHotShowingListData(page, count)
    }
}