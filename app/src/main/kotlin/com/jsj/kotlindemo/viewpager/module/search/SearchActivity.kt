package com.jsj.kotlindemo.viewpager.module.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.module.search.adapter.SearchAdapter

class SearchActivity : AppCompatActivity() {

    var recyclerview: RecyclerView? = null
    var mAdapter: SearchAdapter? = null
    var mList: ArrayList<String> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        recyclerview = findViewById(R.id.recyclerview) as RecyclerView?

        //设置布局管理器
        recyclerview?.layoutManager = LinearLayoutManager(this)
        //设置适配器
        mAdapter = SearchAdapter(this)

        for (i in 0..10) {
            mList.add("搜索历史" + i)
        }

        mAdapter?.setData(mList)
        recyclerview?.adapter = mAdapter

    }
}
