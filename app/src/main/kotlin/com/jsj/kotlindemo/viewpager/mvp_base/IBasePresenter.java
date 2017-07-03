package com.jsj.kotlindemo.viewpager.mvp_base;

/**
 * @author jsj
 * @since 17/5/10
 */

public interface IBasePresenter<V extends IBaseView> {

    /**
     * 绑定接口
     */
    void attachView(V view);

    /**
     * 释放接口
     */
    void detachView();
}
