package com.jsj.kotlindemo.viewpager.rxHttp

import com.jsj.kotlindemo.viewpager.api.OkHttpClientUtils
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @author jsj
 * @since 17/7/24
 */
class HttpHelper {

    companion object {
        private var instance: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClientUtils.getOkHttpClient())
                .build();

        fun instance() = instance;


        /**
         * 获取 Retrofit 的 Service 实例，baseUrl 为 [BuildConfig.API_HOST]。

         * @param serviceClass Retrofit 的 Service 字节码
         * *
         * @param <Service>    Retrofit 的 Service
         * *
         * @return Retrofit 的 Service 实例
        </Service> */
        fun <Api> service(serviceClass: Class<Api>): Api {
            return instance().create(serviceClass)
        }
    }
}