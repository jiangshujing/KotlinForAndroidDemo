package com.jsj.kotlindemo.viewpager.mvp_base

/**
 *
 * @author jsj
 * @since 17/6/12
 */
abstract class BaseModel<SubP> {

    protected var mIPresenter: SubP? = null;

    constructor(){

    }

    constructor(presenter: SubP) : this() {
        this.mIPresenter = presenter;
    }
}