package com.jsj.kotlindemo.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R.layout

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class OrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(layout.fragment_order, container,false)



        return view;
    }
}