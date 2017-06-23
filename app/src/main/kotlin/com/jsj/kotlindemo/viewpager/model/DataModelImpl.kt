package com.jsj.kotlindemo.viewpager.model

import android.util.Log
import com.jsj.kotlindemo.net.ForecastBean
import com.jsj.kotlindemo.net.HttpResult
import com.jsj.kotlindemo.viewpager.api.UrlApi
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Subscriber
import rx.schedulers.Schedulers


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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val movieService = retrofit.create(UrlApi::class.java)
        movieService.getAndroidData(1)
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<HttpResult<List<ForecastBean>>>() {

                    override fun onStart() {
                        listener.showLoading()
                    }

                    override fun onError(p0: Throwable?) {
//                        listener.onFailed()
                    }

                    override fun onCompleted() {
                    }

                    override fun onNext(p0: HttpResult<List<ForecastBean>>?) {
                        Log.d("onNext====", p0.toString());
                        println("onNext====" + p0.toString())
                        listener.onSucceed()
                    }
                })
    }
}
