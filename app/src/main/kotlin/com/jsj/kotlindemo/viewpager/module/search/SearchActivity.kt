package com.jsj.kotlindemo.viewpager.module.search

import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.base.MyApplication
import com.jsj.kotlindemo.dao.UserDao
import com.jsj.kotlindemo.viewpager.module.search.bean.User


class SearchActivity : AppCompatActivity(), (String) -> Unit {

    var et_search: EditText? = null
    var ft: FragmentTransaction? = null
    var mUserDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        mUserDao = (MyApplication.instance() as MyApplication).getDaoSession().userDao
        et_search = findViewById(R.id.et_search) as EditText?
        et_search?.inputType = InputType.TYPE_CLASS_TEXT
        var tv_cancel = findViewById(R.id.tv_cancel) as TextView?
        tv_cancel?.setOnClickListener {


            finish()
        }

        ft = supportFragmentManager.beginTransaction()
        ft?.replace(R.id.content, SearchHistoryFragment(this))
        ft?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft?.commit()

        et_search?.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || event != null && event.keyCode === KeyEvent.KEYCODE_SEARCH) {
                    Toast.makeText(this@SearchActivity, "搜索", Toast.LENGTH_SHORT).show()

                    var mUser = User()
                    mUser.name = et_search?.text.toString()
                    mUserDao?.insert(mUser)//添加一个

                    //隐藏键盘
                    val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.windowToken, 0)

                    var fragment = SearchResultFragment()
                    var bundle: Bundle = Bundle()
                    bundle.putString("search_key", et_search?.text.toString())
                    fragment.arguments = bundle;
                    ft = supportFragmentManager.beginTransaction()
                    ft?.replace(R.id.content, fragment)
                    ft?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ft?.commit()

                    return true
                }
                return false
            }
        })


//        et_search?.setOnKeyListener(View.OnKeyListener { view, keyCode, keyEvent ->
//            if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                // 先隐藏键盘
//                (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
//                        .hideSoftInputFromWindow(this@SearchActivity.getCurrentFocus()
//                                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
//                //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
//                if (et_search?.getText() != null) {
//                    Toast.makeText(this@SearchActivity, "搜索1", Toast.LENGTH_SHORT).show()
//                }
//            }
//            false
//        })
    }


    override fun invoke(searchKey: String) {
        switchFragment(searchKey)
    }

    /**
     * 切换到搜索结果的fragment
     */
    fun switchFragment(searchKey: String) {
        var fragment = SearchResultFragment()
        var bundle: Bundle = Bundle()
        bundle.putString("search_key", searchKey)
        fragment.arguments = bundle;
        var ft = supportFragmentManager.beginTransaction()
        ft?.replace(R.id.content, fragment)
        ft?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft?.commit()
    }
}
