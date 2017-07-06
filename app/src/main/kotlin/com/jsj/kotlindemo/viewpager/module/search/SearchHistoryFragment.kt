package com.jsj.kotlindemo.viewpager.module.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.dao.UserDao
import com.jsj.kotlindemo.viewpager.base.MyApplication
import com.jsj.kotlindemo.viewpager.module.search.adapter.SearchAdapter
import com.jsj.kotlindemo.viewpager.module.search.bean.User

/**
 *
 * @author jsj
 * @since 17/7/6
 */
class SearchHistoryFragment(listener: (searchKey: String) -> Unit) : Fragment() {

    var recyclerview: RecyclerView? = null
    var mAdapter: SearchAdapter? = null
    var mList: ArrayList<User>? = ArrayList();
    var mUserDao: UserDao? = null
    var listener: ((searchKey: String) -> Unit)? = listener;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater?.inflate(R.layout.incloud_recyclerview, container, false)

        recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)

        //设置布局管理器
        recyclerview?.layoutManager = LinearLayoutManager(activity)
        //设置适配器
        mAdapter = SearchAdapter(activity)
        mAdapter?.setOnItemClickListener {
            searchKey ->
            listener?.invoke(searchKey)
        }

        mUserDao = (MyApplication.instance() as MyApplication).getDaoSession().userDao
//        mUserDao?.loadAll()?.let { mList?.addAll(it) } //查询数据库

        //通过Id倒序排序
        mList?.addAll(mUserDao?.queryBuilder()?.orderDesc(UserDao.Properties.Id)?.list()!!)

        mAdapter?.setData(mList)
        recyclerview?.adapter = mAdapter

        return view!!
    }

}