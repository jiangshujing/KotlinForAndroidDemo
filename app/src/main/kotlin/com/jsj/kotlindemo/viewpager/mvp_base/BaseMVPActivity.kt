package com.jsj.kotlindemo.viewpager.mvp_base

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.FragmentActivity

/**
 *
 * @author jsj
 * @since 17/6/30
 */
abstract class BaseMVPActivity<V : IBaseView, P : IBasePresenter<V>> : FragmentActivity(), IBaseDelegate<V, P> {

    override var presenter: P = null!!

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}