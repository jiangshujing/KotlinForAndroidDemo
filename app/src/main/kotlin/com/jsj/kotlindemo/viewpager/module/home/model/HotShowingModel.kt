package com.jsj.kotlindemo.viewpager.module.home.model

import android.content.Context
import android.util.Log
import com.jsj.kotlindemo.viewpager.api.OkHttpClientUtils
import com.jsj.kotlindemo.viewpager.api.UrlApi
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.jsj.kotlindemo.viewpager.module.home.presenter.HotShowingPresenter
import com.jsj.kotlindemo.viewpager.mvp_base.BaseModel
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
 * @since 17/6/30
 */
class HotShowingModel() : BaseModel<HotShowingPresenter>() {

    var context: Context? = null

    constructor(context: Context, presenter: HotShowingPresenter) : this() {
        super.mIPresenter = presenter
        this.context = context
    }


    /**
     * 发起网络请求
     */
    fun getHotShowingListData(start: Int, count: Int) {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClientUtils.getOkHttpClient())
                .build()
        val movieService = retrofit.create(UrlApi::class.java)

        var params = hashMapOf<String, String>()
        params.put("start", start.toString())
        params.put("count", count.toString())

        Log.e("------",params.toList().toString())

        movieService.getHotShowingList(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Bean> {
                    override fun onSubscribe(p0: Disposable?) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(p0: Bean?) {
                        mIPresenter?.onSuccess(p0)
                    }

                    override fun onError(p0: Throwable?) {
                        mIPresenter?.onFailed("onError", -1)
                    }
                })
    }
}