package com.jsj.kotlindemo.viewpager.module.me

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.base.BaseFragment
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

/**
 *
 * @author jsj
 * @since 17/7/13
 */
class Fragment1 : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = UI {

            relativeLayout {
                //                orientation = LinearLayout.HORIZONTAL

                imageView {
                    imageResource = R.mipmap.loading_iv_09
                }.lparams {
                    gravity = Gravity.CENTER
                    centerHorizontally()
                    centerVertically()
                    height = wrapContent
                    width = wrapContent
                }


                weightTextView {
//                    normalDrawable = resources.getDrawable(R.mipmap.default_avatar)
                    text = "lalalallallaal"
                    textSize = 20f
                    textColor = resources.getColor(R.color.black_33)
                    isSelected = true
                }.lparams {
                    height = wrapContent
                    width = wrapContent
                }

            }
        }.view




        return view;
    }


}