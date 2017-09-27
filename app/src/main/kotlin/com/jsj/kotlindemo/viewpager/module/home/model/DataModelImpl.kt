package com.jsj.kotlindemo.viewpager.module.home.model

import com.jsj.kotlindemo.viewpager.api.UrlApi
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.rxHttp.HttpHelper
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 *
 * @author jsj
 * @since 17/6/12
 */
class DataModelImpl(val listener: DataModel.DataListener) : DataModel {


    /**
     * 发起网络请求
     */
    override fun getData(page: Int, type: String) {

        HttpHelper.service(UrlApi::class.java).getAndroidData(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Bean> {
                    override fun onSubscribe(p0: Disposable?) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(p0: Bean?) {
                        listener.onSucceed(p0)
                    }

                    override fun onError(p0: Throwable?) {
                        listener.onFailed("onError")
                    }
                })
    }
}

