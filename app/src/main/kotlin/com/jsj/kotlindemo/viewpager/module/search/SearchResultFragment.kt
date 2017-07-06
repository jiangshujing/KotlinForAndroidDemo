package com.jsj.kotlindemo.viewpager.module.search

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.view.AloadingView
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.presenter.SearchPresenter
import com.jsj.kotlindemo.viewpager.module.home.view.SearchView
import com.jsj.kotlindemo.viewpager.module.search.adapter.SearchResultAdapter
import com.jsj.kotlindemo.viewpager.mvp_base.BaseMVPFragment

/**
 *
 * @author jsj
 * @since 17/7/6
 */
class SearchResultFragment : BaseMVPFragment<SearchView, SearchPresenter>(), SearchView {

    var recyclerview: RecyclerView? = null;
    var mAdapter: SearchResultAdapter? = null;
    var loadingview : AloadingView? = null


    override fun showLoading() {
        loadingview?.showLoading()
    }

    override fun onFailed(reason: String, code: Int) {
        Toast.makeText(activity,reason,Toast.LENGTH_SHORT).show()
        loadingview?.showError()
    }

    override fun createPresenter(): SearchPresenter {
        return SearchPresenter(activity, this@SearchResultFragment)
    }

    override fun onSuccess(date: Bean?) {
        loadingview?.showContent()
        mAdapter?.setData(date?.subjects)
        recyclerview?.adapter = mAdapter
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater?.inflate(R.layout.incloud_recyclerview, container, false)
        loadingview = view?.findViewById<AloadingView>(R.id.loadingview)
        recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview?.layoutManager =LinearLayoutManager(activity)

        mAdapter = SearchResultAdapter(activity);
        mAdapter?.setOnItemClickListener {

            searchKey ->
            Toast.makeText(activity, searchKey, Toast.LENGTH_SHORT).show()

        }


        var search_key = arguments.getString("search_key")

        createPresenter().getSearchListData(search_key, 1, 10)

        return view
    }

}