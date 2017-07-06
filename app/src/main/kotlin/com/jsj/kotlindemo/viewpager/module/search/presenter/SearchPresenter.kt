package com.jsj.kotlindemo.viewpager.module.home.presenter

import android.content.Context
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.model.SearchModel
import com.jsj.kotlindemo.viewpager.module.home.view.SearchView
import com.jsj.kotlindemo.viewpager.mvp_base.IBasePresenter

/**
 *
 * @author jsj
 * @since 17/6/30
 */
class SearchPresenter(context: Context, view: SearchView) : IBasePresenter<SearchView> {

    var mContext = context
    var mView = view
    var mModel: SearchModel? = null

    init {
        attachView(view)
        mModel = SearchModel(mContext, this@SearchPresenter)
    }

    override fun attachView(view: SearchView?) {
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

    fun onSuccess(data: Bean?) {
        if (mView != null)
            mView.onSuccess(data)
    }

    fun getSearchListData(searchKey: String, page: Int, count: Int) {
        mModel?.getSearchListData(searchKey,page, count)
    }
}