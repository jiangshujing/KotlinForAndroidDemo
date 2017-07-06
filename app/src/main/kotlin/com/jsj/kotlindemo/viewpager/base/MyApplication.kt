package com.jsj.kotlindemo.viewpager.base

import android.app.Application
import com.jsj.kotlindemo.dao.DaoMaster
import com.jsj.kotlindemo.dao.DaoSession

/**
 *
 * @author jsj
 * @since 17/6/27
 */
class MyApplication : Application() {

    private var daoSession: DaoSession? = null

    companion object {
        private var instance: Application? = null;
        fun instance() = instance;
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDao()
    }


    fun initDao() {
        val helper = DaoMaster.DevOpenHelper(this, "user")
        val db = helper.writableDb
        daoSession = DaoMaster(db).newSession()
    }

    open fun getDaoSession(): DaoSession {
        return daoSession!!
    }

}