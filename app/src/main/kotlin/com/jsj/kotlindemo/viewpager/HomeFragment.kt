package com.jsj.kotlindemo.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R.layout
import com.jsj.kotlindemo.net.ForecastBean
import com.jsj.kotlindemo.viewpager.presenter.DataPresenterImpl
import com.jsj.kotlindemo.viewpager.view.DataView

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class HomeFragment : Fragment(), DataView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailed(reason: String, code: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(data: List<ForecastBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(layout.fragment_home, container, false)


        val presenter: DataPresenterImpl = DataPresenterImpl(this)
        presenter.getData(1,"")

        return view;
    }
}