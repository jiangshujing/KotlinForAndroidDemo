package com.jsj.kotlindemo.viewpager.rxHttp

import android.content.Context
import android.util.Log
import com.jsj.kotlindemo.net.HttpResult
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 *
 * @author jsj
 * @since 17/6/27
 */
abstract class BaseObserver<T> : Observer<HttpResult<T>> {
    private val RESPONSE_CODE_OK: Int = 0;       //自定义的业务逻辑，成功返回积极数据
    private val RESPONSE_FATAL_EOR: Int = -1;  //返回数据失败,严重的错误

    private var mCode: Int = -1111;
    private var mMsg: String = "未知的错误！";

    private val context: Context? = null;


    init {
        onStart();
    }

    override fun onSubscribe(p0: Disposable?) {
    }

    override fun onComplete() {
    }

    override fun onError(p0: Throwable?) {
        Log.e("", p0.toString())
        mCode = RESPONSE_FATAL_EOR
        onFailed("", mCode)
    }

    override fun onNext(response: HttpResult<T>?) {

        try {
            if (response == null) {
                onFailed("", RESPONSE_FATAL_EOR)
                return
            }
            mCode = response.code
            mMsg = response.msg
            when (mCode) {
                RESPONSE_CODE_OK -> onSuccess(response.body)//返回码为0
//                SESSION_OUTOFDATA -> {//返回码为session 失效码
//                    val intent = Intent()
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                    intent.setClass(MyApplication.getContext(), LoginActivity::class.java)
//                    MyApplication.getContext().startActivity(intent)
//                    MyToast.makeText(MyApplication.getContext(), response.msg)
//                    onFailed(response.msg, mCode)
//                }
                else -> onFailed(mMsg, mCode)
            }
        } catch (e: Exception) {
            Log.e("", e.toString())
        }
    }

    /**
     * @return 网络请求返回码
     */
    protected fun getCode(): Int {
        return mCode
    }

    /**
     * @return 网络请求返回Msg
     */
    protected fun getMsg(): String {
        return mMsg
    }

    /**
     * 请求成功，获取期望的结果
     * @param bean 结果对象
     */
    abstract fun onSuccess(bean: T)


    /**
     * 请求失败，或者结果状态为失败
     * @param msg
     * @param id
     */
    abstract fun onFailed(msg: String, code: Int)


    /**
     * 开始请求
     */
    abstract fun onStart()
}