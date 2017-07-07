package com.jsj.kotlindemo.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 *
 * @author jsj
 * @since 17/7/7
 */
abstract class BaseAdapter<T>(val data: ArrayList<T>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var holder = BaseViewHolder(getViewResource(viewType))
        return holder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        bindData(holder?.itemView, data?.get(position), position)
    }

    abstract fun getViewResource(viewType: Int): View

//    abstract fun addAllViewItems(viewMap: SparseArray<View>?, root: View)

    abstract fun bindData(itemView: View?, t: T?, position: Int)

    class BaseViewHolder : RecyclerView.ViewHolder {

        constructor(itemView: View?) : super(itemView)
    }
}