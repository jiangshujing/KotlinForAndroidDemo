package com.jsj.kotlindemo.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class ViewPagerAdapter(tabTitle: List<String>?, fragments: List<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragments: List<Fragment>? = null;
    var tabTitle: List<String>? = null;

    init {
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }


    override fun getItem(position: Int): Fragment? {
        return fragments!![position];
    }

    override fun getCount(): Int {
        return fragments!!.size;
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (tabTitle == null || tabTitle?.size == 0)
            return null!!;
        return tabTitle!![position];
    }
}