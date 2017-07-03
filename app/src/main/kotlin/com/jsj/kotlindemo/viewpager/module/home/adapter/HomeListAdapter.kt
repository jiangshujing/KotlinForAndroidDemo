package com.jsj.kotlindemo.viewpager.module.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jsj.kotlindemo.R
import com.jsj.kotlindemo.viewpager.module.home.bean.Bean
import com.squareup.picasso.Picasso

/**
 *
 * @author jsj
 * @since 17/6/26
 */
class HomeListAdapter constructor(context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: List<Bean.SubjectsBean>? = null;
    private var context: Context? = context;
    private var listener: ((position: Int) -> Unit)? = null


    fun setDate(list: List<Bean.SubjectsBean>?) {
        this.list = list
    }

    fun setOnItemClickListener(listener: ((position: Int) -> Unit)) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_home_list, parent, false)
        return ItemViewHolder(view);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var item: Bean.SubjectsBean? = list?.get(position)
        (holder as ItemViewHolder).tv_title?.text = item?.title
        holder.tv_collect_count?.text = "${item?.collectCount} 人想看"

        var directors: String = ""
        item?.directors?.forEach {
            directors = "$directors/${it.name}"
        }

        holder.tv_directors?.text = directors

        item?.casts?.fold("") {
            castsName, next ->
            "$castsName/${next.name}"
        }

        var name = item?.casts?.fold("") {
            castsName, next ->
            "$castsName/${next.name}"
        }

//        holder.tv_casts?.text = name?.substring(1, (name?.length))
        Picasso.with(context?.applicationContext).load(item?.images?.medium).placeholder(R.mipmap.ic_launcher).into(holder.iv_image)

        holder.ll_item?.setOnClickListener {
            listener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val tv_title: TextView? = itemView?.findViewById<TextView>(R.id.tv_title)
        val ll_item = itemView?.findViewById<LinearLayout>(R.id.ll_item)
        val tv_collect_count = itemView?.findViewById<TextView>(R.id.tv_collect_count)
        val tv_directors = itemView?.findViewById<TextView>(R.id.tv_directors)
        val tv_casts = itemView?.findViewById<TextView>(R.id.tv_casts)
        val iv_image = itemView?.findViewById<ImageView>(R.id.iv_image)
    }
}