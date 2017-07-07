package com.jsj.kotlindemo.test

/**
 *
 * @author jsj
 * @since 17/7/7
 */
class Test {
    var v = "成员属性"

    /**
     * 嵌套类
     */
    class Nested {
        fun nestedTest() {
            println("嵌套类中的方法")
        }
    }

    /**
     * 内部类
     */
    inner class Inner {
        fun innerTest() {
            println("内部类中的方法")
        }
    }

    fun setInterFace(test: TestInterFace) {
        test.test()
    }

    /**
     * 接口
     */
    interface TestInterFace {
        fun test()
    }

}