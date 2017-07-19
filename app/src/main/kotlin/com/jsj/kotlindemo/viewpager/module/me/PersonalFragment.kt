package com.jsj.kotlindemo.viewpager.module.me

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.*
import android.widget.LinearLayout
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.view.WeightTextView
import com.jsj.kotlindemo.viewpager.ViewPagerAdapter
import kotlinx.android.synthetic.main.dialog.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.viewPager

/**
 *
 * @author jsj
 * @since 17/6/10
 */
class PersonalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val arr: ArrayList<String> = ArrayList()

        var tab: TabLayout? = null

        var viewPager: ViewPager? = null

        var fragments: ArrayList<Fragment>? = ArrayList()

        var view = UI {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                relativeLayout {
                    backgroundResource = R.color.green

                    //头像
                    var iv_avatar = imageView {
                        id = R.id.iv_avatar
                        imageResource = R.mipmap.default_avatar
                    }.lparams {
                        centerVertically()
                        rightMargin = dip(20)
                        leftMargin = dip(10)
                    }

                    //登陆
                    var tv_login = textView {
                        textSize = 20f
                        textColor = Color.WHITE
                        text = "请登录"

                    }.lparams {
                        centerVertically()
                        rightOf(iv_avatar)

                    }

                    //设置
                    var tv_setting = textView {
                        textSize = 16f
                        textColor = Color.WHITE
                        text = "设置"
                        setOnClickListener {
                            showDialog();
//                            Toast.makeText(activity, "设置", Toast.LENGTH_SHORT).show()
                        }

                    }.lparams {
                        alignParentRight()
                        rightMargin = dip(10)

                    }
                }.lparams {
                    height = dip(150)
                    width = matchParent
                }

                tab = tabLayout {
                    id = R.id.tablayout

                }.lparams {
                    height = dip(40)
                    width = matchParent
                }

                viewPager = viewPager {
                    id = R.id.viewpager
                    backgroundResource = R.color.gray_e5e5e5

                }.lparams {
                    height = dip(0)
                    width = matchParent
                    weight = 1f
                }
            }

        }.view


        arr.add("想看")
        arr.add("在看")
        arr.add("看过")
        arr.add("影评")
        arr.add("影人")

        fragments?.add(Fragment1())
        fragments?.add(Fragment1())
        fragments?.add(Fragment1())
        fragments?.add(Fragment1())
        fragments?.add(Fragment1())

        val adapter = ViewPagerAdapter(arr, fragments, childFragmentManager);
        tab?.addTab(tab?.newTab()?.setText(arr.get(0))!!)
        tab?.addTab(tab?.newTab()?.setText(arr.get(1))!!)
        tab?.addTab(tab?.newTab()?.setText(arr.get(2))!!)
        tab?.addTab(tab?.newTab()?.setText(arr.get(3))!!)
        tab?.addTab(tab?.newTab()?.setText(arr.get(4))!!)

        tab?.setSelectedTabIndicatorColor(R.color.black_33)
        tab?.setTabMode(TabLayout.MODE_FIXED);//tab不能滚动，平分屏幕宽度
        // 设置TabLayout模式
//        tab?.setTabMode(TabLayout.MODE_SCROLLABLE);//tab可以滚动，tab宽度根据内容自动缩放

        viewPager?.adapter = adapter
        viewPager?.setOffscreenPageLimit(arr.size - 1)
        tab?.setupWithViewPager(viewPager)

        return view;
    }

    fun showDialog() {

//        alert("我是Dialog") {
//
//            yesButton { toast("yes") }
//            noButton { toast("no") }
//        }.show()

        val dialog = showLayoutDialog {
            setContentView(R.layout.dialog)
            setCanceledOnTouchOutside(false)
            setCancelable(true)
//            removeY = -300
            gravity = Gravity.CENTER

            //测试gitFlow
            //模拟更新代码
            //
            //
            //在 release/3.0 上开发的
            // 新功能开发
        }

        with(dialog) {
            dialog_content.setText("我是一个提示框")
            dialog_ok.setOnClickListener {
                dismiss()
            }
        }
    }


    // AlertDialog的模板
    fun Activity.showLayoutDialog(init: AlertDialog.() -> Unit): AlertDialog {
        val view = AlertDialog.Builder(this).create()
        view.show()
        view.init()
        val window = view.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        return view
    }

    var AlertDialog.removeY: Int
        get() {
            val window = window
            val lp = window.attributes
            return lp.y
        }
        set(value) {
            val window = window
            val lp = window.attributes
            lp.y = value
        }

    var AlertDialog.gravity: Int
        get() {
            val window = window
            val lp = window.attributes
            return lp.y
        }
        set(value) {
            val window = window
            val lp = window.attributes
            lp.gravity = value
        }

    fun Fragment.showLayoutDialog(init: AlertDialog.() -> Unit): AlertDialog {
        return activity.showLayoutDialog { init() }
    }
}

inline fun ViewManager.weightTextView() = weightTextView {}
inline fun ViewManager.weightTextView(init: WeightTextView.() -> Unit) = ankoView({ WeightTextView(it) }, 0, init)