package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/8/10
 */
enum class Color(val r: Int,
                 val g: Int,
                 val b: Int) {

    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    //给枚举类添加方法，注意要使用分号把枚举常亮列表和方法定义分开
    fun rgb() = (r * 256 + g) * 256 + b
}