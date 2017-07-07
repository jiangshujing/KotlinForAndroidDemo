package com.jsj.kotlindemo.viewpager.module.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.dao.UserDao
import com.jsj.kotlindemo.base.MyApplication
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
        var view = inflater?.inflate(R.layout.fragment_search_history, container, false)

        mUserDao = (MyApplication.instance() as MyApplication).getDaoSession().userDao
        view?.findViewById<TextView>(R.id.tv_clean)?.setOnClickListener {
            mUserDao?.deleteAll()//清空搜索记录
            //刷新adapter
            mList?.clear()
            mUserDao?.loadAll()?.let { mList?.addAll(it) } //查询数据库
            mAdapter?.setData(mList)
            mAdapter?.notifyDataSetChanged()
        }
        recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)

        //设置布局管理器
        recyclerview?.layoutManager = LinearLayoutManager(activity)
        //设置适配器
        mAdapter = SearchAdapter(activity)
        mAdapter?.setOnItemClickListener {
            searchKey ->
            listener?.invoke(searchKey)
        }


//        mUserDao?.loadAll()?.let { mList?.addAll(it) } //查询数据库

        //通过Id倒序排序
        mList?.addAll(mUserDao?.queryBuilder()?.orderDesc(UserDao.Properties.Id)?.list()!!)

        mAdapter?.setData(mList)
        recyclerview?.adapter = mAdapter

        return view!!
    }

}