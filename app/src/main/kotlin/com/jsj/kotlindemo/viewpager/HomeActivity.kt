package com.jsj.kotlindemo.viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jsj.kotlindemo.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.main_tab.*

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class HomeActivity : AppCompatActivity(), View.OnClickListener {

    var fragments = ArrayList<Fragment>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var fragment1: HomeFragment = HomeFragment();
        var fragment2: OrderFragment = OrderFragment();
        var fragment3: PersonalFragment = PersonalFragment();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        val viewpagerAdapter: ViewPagerAdapter = ViewPagerAdapter(null, fragments, supportFragmentManager)
        viewpager.adapter = viewpagerAdapter;


        main_rb_home.setOnClickListener(this)
        main_rb_order.setOnClickListener(this)
        main_rb_presonal.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.main_rb_home -> {
                viewpager.setCurrentItem(0, false)
                main_rb_home.isChecked = true
                main_rb_order.isChecked = false
                main_rb_presonal.isChecked = false
            }

            R.id.main_rb_order -> {
                viewpager.setCurrentItem(1, false)
                main_rb_home.isChecked = false
                main_rb_order.isChecked = true
                main_rb_presonal.isChecked = false
            }

            R.id.main_rb_presonal -> {
                viewpager.setCurrentItem(2, false)
                main_rb_home.isChecked = false
                main_rb_order.isChecked = false
                main_rb_presonal.isChecked = true
            }
        }
    }
}