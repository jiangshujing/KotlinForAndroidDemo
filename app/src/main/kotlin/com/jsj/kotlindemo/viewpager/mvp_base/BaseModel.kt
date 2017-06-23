package com.jsj.kotlindemo.viewpager.mvp_base

/**
 *
 * @author jsj
 * @since 17/6/12
 */
class BaseModel<SubP>(val presenter: SubP) {

    protected val mIPresenter: SubP = null!!;

    init {
        this.mIPresenter = presenter;
    }
}