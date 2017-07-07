package com.jsj.kotlindemo.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.jsj.kotlindemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        demo1();
//        demo3();
//
        val person: Person = Person("小明");
//        val person2: Person = Person("小红", 12);
//        println("name:" + person2.name + "age:" + person2.age);

//        val student : Student = Student();
//        student.study();


//        val button: Button = findViewById(R.id.button) as Button;
//
//        button.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View) {
//                Toast.makeText(v.context, "button", Toast.LENGTH_SHORT).show();
//            }
//        });

        button.setOnClickListener(this);

        //调用嵌套类
        Test.Nested().nestedTest()

        //调用内部类
        Test().Inner().innerTest()

        //接口对象
        Test().setInterFace(object : Test.TestInterFace {
            override fun test() {
                println("匿名内部类的实现")
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                Toast.makeText(v.context, "button", Toast.LENGTH_SHORT).show();
            }
        }
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }

        //同时还可以使用!is，来取反
        if (obj !is String) {
        }

        // 代码块外部的obj仍然是Any类型的引用
        return null
    }

    fun hasEmpty(vararg strArray: String?): Boolean {
        for (str in strArray) {
            if ("".equals(str) || str == null)
                return true
        }
        return false
    }

    fun demo() {
        var name: String? = "abc";
        if (name != null)
            name.length;


        name?.length;

    }

    /**
     * 数字类型
     */
    fun demo1() {
        val a: Int = 1000;
        val b: Int = 1000;
        println(a == b);//true
        println(a === b);//true

        val c: Int? = 1000;
        val d: Int? = 1000;
        println(c == d);//true
        println(c === d);//false
    }

    /**
     * 类型转换
     */
    fun demo2() {
        var a: Byte = 10;
//        var b:Int = a;

        var b: Int = a.toInt();
    }

    /**
     * 字符串
     */
    fun demo3() {
        var text1: String = """ hello\nWorld """;
        var text2: String = "hello\n";

        println(text1);
        println(text2);
    }
}
