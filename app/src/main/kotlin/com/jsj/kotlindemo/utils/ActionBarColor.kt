package com.jsj.kotlindemo.utils

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.view.Window
import android.view.WindowManager
import com.jsj.kotlindemo.R

/**
 *
 * @author jsj
 * @since 17/7/13
 */
class ActionBarColor {

    companion object {
        /**
         * Apply KitKat specific translucency.
         */
        fun applyKitKatTranslucency(act: Activity, window: Window) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(true, window)
                val mTintManager = SystemBarTintManager(act)
                mTintManager.setStatusBarTintEnabled(true)
                /*
                 * 修改通知栏字体颜色
                 */
                mTintManager.setStatusBarTintResource(R.color.transparent)
            }
        }

        @TargetApi(19)
        private fun setTranslucentStatus(on: Boolean, window: Window) {
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
    }


}