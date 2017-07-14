package com.jsj.kotlindemo.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.WindowManager

/**
 *
 * @author jsj
 * @since 17/7/10
 */
class BaseFragmentActivity : FragmentActivity() {

    protected val TAG: String = BaseFragmentActivity::class.java.simpleName
    protected var mContext: Context? = null;
    protected var mFragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this@BaseFragmentActivity;
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        applyKitKatTranslucency()
        ActivityManager.getScreenManager().pushActivity(this)
        mFragmentManager = supportFragmentManager
    }

    protected fun setRootView(layoutResID: Int) {
        val inflater = LayoutInflater.from(this)
        val root = inflater.inflate(layoutResID, null)
        setContentView(root)
//        AbViewUtil.scaleContentView(root as ViewGroup)
    }

    /**
     * Apply KitKat specific translucency.
     */
    protected fun applyKitKatTranslucency() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true)
//            val mTintManager = SystemBarTintManager(this@BaseFragmentActivity)
//            mTintManager.setStatusBarTintEnabled(true)
            /*
             * 修改通知栏字体颜色
             */
//            mTintManager.setStatusBarTintResource(R.color.background_all)
        }
    }

    @TargetApi(19)
    private fun setTranslucentStatus(on: Boolean) {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    override fun onResume() {
        super.onResume()
//        MobclickAgent.onPageStart(TAG)
//        MobclickAgent.onResume(this)
        //        LogUtil.d("onResume");
    }

    override fun onPause() {
        super.onPause()
//        MobclickAgent.onPageEnd(TAG)
//        MobclickAgent.onPause(this)
        //        LogUtil.d("onPause");
    }

    override fun onDestroy() {
        super.onDestroy()
        //        LogUtil.d("onDestroy");
        ActivityManager.getScreenManager().popActivity(this)
    }

    fun setBgAlpha(bgAlpha: Float) {
        val lp = window.attributes
        lp.alpha = bgAlpha
        window.attributes = lp
    }
}