package com.jsj.kotlindemo.viewpager.api

import com.jsj.kotlindemo.net.ForecastBean
import com.jsj.kotlindemo.net.HttpResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface UrlApi {


    /**
     * 获取所有数据 -- 使用Retrofit + RxJava
//     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int): Observable<HttpResult<List<ForecastBean>>>
}