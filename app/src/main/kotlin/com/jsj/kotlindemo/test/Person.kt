package com.jsj.kotlindemo.test


/**
 *
 * @author jsj
 * @since 17/5/27
 */
class Person  constructor(var name: String) {

    var age: Int = 0;
    var sex: String = "";

    init {
        println("初始化数据");
        this.name = name;
    }

    //二级构造函数 -- 委托给主构造函数
    constructor(name: String, age: Int) : this(name) {
        this.age = age;
    }

    //委托给两个参数的构造函数
    constructor(name: String, age: Int, sex: String) : this(name, age) {
        this.sex = sex;
    }
}