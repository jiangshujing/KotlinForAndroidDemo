package com.jsj.kotlindemo.viewpager.module.middle

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.presenter.CelebrityPresenter
import com.jsj.kotlindemo.viewpager.module.home.view.CelebrityView
import com.jsj.kotlindemo.viewpager.module.middle.adapter.HorizontalAdapter
import com.jsj.kotlindemo.viewpager.mvp_base.BaseMVPFragment


/**
 *
 * @author jsj
 * @since 17/6/10
 */
class OrderFragment : BaseMVPFragment<CelebrityView, CelebrityPresenter>(), CelebrityView {

    var list: List<Bean.SubjectsBean>? = ArrayList()
    var mAdapter: HorizontalAdapter? = null
    var recyclerview: RecyclerView? = null

    override fun showLoading() {
    }

    override fun onFailed(reason: String, code: Int) {
    }

    override fun createPresenter(): CelebrityPresenter {
        return CelebrityPresenter(activity, this@OrderFragment)
    }

    override fun onSuccess(date: Bean?) {
        list = date?.subjects
        mAdapter?.setData(list)
        recyclerview?.setAdapter(mAdapter)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_order, container, false)
        recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        view.findViewById<TextView>(R.id.tv_more).setOnClickListener {
            Toast.makeText(activity, "更多", Toast.LENGTH_SHORT).show()
        }

        //设置布局管理器
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerview?.setLayoutManager(linearLayoutManager)
        //设置适配器
        mAdapter = HorizontalAdapter(activity)

        createPresenter().getHotShowingListData(1, 10);

        return view;
    }
}