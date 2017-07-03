package com.jsj.kotlindemo.net

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jsj.kotlindemo.R
import org.jetbrains.anko.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class GetNetActivity : AppCompatActivity() {

    val itmes = ArrayList<ForecastBean>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_net)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview) as RecyclerView;
//        recyclerView.layoutManager = GridLayoutManager(this, 2)

        initData();

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter: ListAdapter = ListAdapter(itmes)
        adapter.setOnItemClickListener { pos -> toast("$pos") }
        recyclerView.adapter = adapter;


    }

    fun initData(){
        val bean1 : ForecastBean = ForecastBean("小明","http://mpic.tiankong.com/365/99f/36599f05cdb059e3bdfc0c56fb9c5423/640.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/watermark,image_cXVhbmppbmcucG5n,t_90,g_ne,x_5,y_5");
        val bean2 : ForecastBean = ForecastBean("小红","http://preview.quanjing.com/pm0025/pm0025-7808hm.jpg");
        val bean3 : ForecastBean = ForecastBean("小蓝","http://preview.quanjing.com/pm0054/pm0054-1680hp.jpg");

        itmes.add(bean1);
        itmes.add(bean2);
        itmes.add(bean3);
    }


    fun getData() {

        val url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101010100"

        //子线程
        async {
            val result = URL(url).readText(Charsets.UTF_8);

            uiThread {
                //                Gson().fromJson(result,)
//                Log.d("NET----","result")
            }
        }
    }
}
