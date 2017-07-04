package com.jsj.kotlindemo.viewpager.module.search.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import kotlinx.android.synthetic.main.item_search.view.*

/**
 *
 * @author jsj
 * @since 17/7/4
 */
class SearchAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: ArrayList<String> = ArrayList();
    fun setData(list: ArrayList<String>) {
        this.list = list
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ItemViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        return ItemViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_search, parent, false))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            itemView.tv_search_key.text = list[position]
        }
    }
}