package com.jsj.kotlindemo.utils

import android.content.Context
import android.view.View

/**
 *
 * @author jsj
 * @since 17/6/27
 */
class ViewExtensions {
    val View.ctx: Context
        get() = context
}