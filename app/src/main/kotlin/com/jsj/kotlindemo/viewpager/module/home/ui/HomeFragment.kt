package com.jsj.kotlindemo.viewpager.module.home.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.ViewPagerAdapter

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class HomeFragment : Fragment() {

    val fragments: ArrayList<Fragment> = java.util.ArrayList();
    var list_Title : ArrayList<String> = ArrayList();

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        val viewpager = view?.findViewById<ViewPager>(R.id.viewpager)
        val tablayout = view?.findViewById<TabLayout>(R.id.tablayout)

        fragments.clear()
        fragments.add(HotShowingFragment())
        fragments.add(ComingSoonFragment())

        val adapter = ViewPagerAdapter(list_Title, fragments, childFragmentManager);
        viewpager?.adapter = adapter

        list_Title.clear()
        list_Title.add("正在热映")
        list_Title.add("即将上映")

        tablayout?.addTab(tablayout.newTab().setText(list_Title.get(0)))
        tablayout?.addTab(tablayout.newTab().setText(list_Title.get(1)))

//        val mTabAdapter = MyFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList, list_Title)
        viewpager?.setAdapter(adapter)
        viewpager?.setOffscreenPageLimit(2)
        tablayout?.setupWithViewPager(viewpager)

        return view!!;
    }

}