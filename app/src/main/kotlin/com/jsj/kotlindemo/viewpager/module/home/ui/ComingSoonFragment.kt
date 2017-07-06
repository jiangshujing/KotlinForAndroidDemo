package com.jsj.kotlindemo.viewpager.module.home.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.DetailsActivity
import com.jsj.kotlindemo.viewpager.module.home.adapter.HomeListAdapter
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.presenter.DataPresenterImpl
import com.jsj.kotlindemo.viewpager.module.home.view.DataView
import kotlinx.android.synthetic.main.fragment_home_hot_showing.*

/**
 *
 * @author jsj
 * @since 17/6/29
 * 热映的fragment
 */
class ComingSoonFragment : Fragment(), DataView, SwipeRefreshLayout.OnRefreshListener {

    private var adapter: HomeListAdapter? = null;
    private var swipe_item: SwipeRefreshLayout? = null;
    private var presenter: DataPresenterImpl? = null;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_home_hot_showing, container, false)
        //此处使用了属性委托 由Lazy委托组成，直至属性第一次被调用，相关代码是不会执行
        val recyclerview by lazy {
            view.findViewById<RecyclerView>(R.id.recyclerview)
        }
        swipe_item = view.findViewById<SwipeRefreshLayout>(R.id.swipe_item)
        swipe_item?.setOnRefreshListener(this)
        swipe_item?.setColorSchemeResources(R.color.background_all)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        adapter = HomeListAdapter(activity)
        adapter?.setOnItemClickListener {
            position ->
            run {

                //                var intent = Intent(activity, DetailsActivity::class.java)
//                intent.putExtra("id", 0)
//                intent.putExtra("name", "aa")
//                startActivity(intent)

                val id = 10;
                val name = "city"

                startActivity<DetailsActivity>()
            }
        }



        presenter = DataPresenterImpl(this)
        presenter?.getData(1, "")


//        val e = Example()
//        e.msg = "first Message"
//        e.msg = "second Message"
        return view;
    }


    inline fun <reified T : Activity> Fragment.startActivity() {
        startActivity(Intent(activity, T::class.java))
    }


    override fun showLoading() {
    }

    override fun onFailed(reason: String, code: Int) {
        swipe_item?.isRefreshing = false
        Toast.makeText(activity,reason,Toast.LENGTH_SHORT).show()
    }

    override fun setData(data: Bean?) {
        swipe_item?.isRefreshing = false
        adapter?.setDate(data?.subjects)
        recyclerview?.adapter = adapter
    }

    override fun onRefresh() {
        presenter?.getData(1, "")
    }
}