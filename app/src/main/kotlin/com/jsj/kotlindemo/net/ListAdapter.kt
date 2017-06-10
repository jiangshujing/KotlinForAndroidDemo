package com.jsj.kotlindemo.net

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsj.kotlindemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*


/**
 *
 * @author jsj
 * @since 17/6/10
 */
class ListAdapter(val items: List<ForecastBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mListener: ((pos: Int) -> Unit)? = null

    /*
      这里使用的是lambda  左边是参数，右面为结果，如果没有返回类型使用Unit
      如：
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                toast(view.id.toString())
            }
        })

        简写：

        button.setOnClickListener(){
               view -> toast(view.id.toString())

        }

     */
    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }


    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        //改变作用域，with{}都是属于itemView
//        with(holder?.itemView!!){
//            tv_name?.text = items[position];
//            tv_name?.setOnClickListener{
//                mListener?.invoke(position)
//            }
//        }

        //类型转换使用as
        (holder as ItemViewHolder).bindItemView(position);
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view);
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItemView(position: Int) {
            with(itemView) {
                tv_name.text = items[position].name;
//                iv_image.setImageResource(R.mipmap.ic_launcher_round);
                Picasso.with(context.applicationContext).load(items[position].image).into(iv_image)
            }
        }
    }
}