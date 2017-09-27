package com.jsj.kotlindemo.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jsj.kotlindemo.test.Rectangle;
import com.jsj.kotlindemo.test.StringFunctions;
import com.jsj.kotlindemo.viewpager.DetailsActivityKt;


/**
 * @author jsj
 * @since 17/8/10
 */

public class MainActivityJava extends AppCompatActivity{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Rectangle rectangle = new Rectangle(3,4);
        rectangle.isSquare();
        StringFunctions.joinToString();
        DetailsActivityKt.lastChar("kotlin");
        DetailsActivityKt.getLastChar("Kotlin");
        DetailsActivityKt.setLastChar(new StringBuilder(),'H');
    }



}
