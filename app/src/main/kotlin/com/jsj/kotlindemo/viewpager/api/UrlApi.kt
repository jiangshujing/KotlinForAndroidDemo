package com.jsj.kotlindemo.viewpager.api

import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import io.reactivex.Observable
import retrofit2.http.*

/**
 *
 * @author jsj
 * @since 17/6/12
 */
interface UrlApi {
    /**
     * 获取所有数据 -- 使用Retrofit + RxJava
    //     */
    @GET("coming_soon")
    fun getAndroidData(@Query("start") page: Int): Observable<Bean>

    @FormUrlEncoded
    @POST("in_theaters")
    fun getHotShowingList(@FieldMap params: Map<String, String>): Observable<Bean>

    /**
     * 获取影人列表
     */
    @GET("top250")
    fun getCelebrityList(@Query("id") page: Int): Observable<Bean>

    /**
     * 搜索
     */
    @GET("search")
    fun getSearchList(@Query("tag") key: String, @Query("start") page: Int, @Query("count") count: Int): Observable<Bean>
}