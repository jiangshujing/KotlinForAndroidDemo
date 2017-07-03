package com.jsj.kotlindemo.viewpager.module.middle.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_celebrity.view.*

/**
 *
 * @author jsj
 * @since 17/7/3
 */
class HorizontalAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var list: List<Bean.SubjectsBean>? = null;
    var context: Context = context;

    fun setData(list: List<Bean.SubjectsBean>?) {
        this.list = list;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ItemViewHolder).bindItemView(position)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_celebrity, parent, false)
        return ItemViewHolder(view)
    }


    inner class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindItemView(position: Int) {
            with(itemView) {
                tv_name.text = list?.get(position)?.title;
                Picasso.with(context.applicationContext).load(list?.get(position)?.images?.large).placeholder(R.mipmap.ic_launcher).into(image)
//                ll_root.setOnClickListener {
//                    listener.invoke(position)
//                }
            }
        }

    }
}