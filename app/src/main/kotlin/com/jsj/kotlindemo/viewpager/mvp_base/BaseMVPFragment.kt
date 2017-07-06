package com.jsj.kotlindemo.viewpager.mvp_base

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * mvp activity基类
 * @param <V>
 * *
 * @param <P>
</P></V> */
abstract class BaseMVPFragment<V : IBaseView, P : IBasePresenter<V>> : Fragment(), IBaseDelegate<V, P> {

    override var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        presenter = createPresenter()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        presenter?.detachView()
        super.onDestroyView()

    }

}