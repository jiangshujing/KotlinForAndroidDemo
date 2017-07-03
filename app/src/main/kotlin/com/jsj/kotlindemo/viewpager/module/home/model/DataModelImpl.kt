package com.jsj.kotlindemo.viewpager.module.home.model

import com.jsj.kotlindemo.viewpager.api.OkHttpClientUtils
import com.jsj.kotlindemo.viewpager.api.UrlApi
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


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

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClientUtils.getOkHttpClient())
                .build()
        val movieService = retrofit.create(UrlApi::class.java)
        movieService.getAndroidData(1)
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

