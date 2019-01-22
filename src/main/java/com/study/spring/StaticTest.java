package com.study.spring;

/**
 * 功能描述:
 *
 * @package com.study.spring
 * @auther vilderlee
 * @date 2019-01-17 21:25
 */
public class StaticTest {
    static {
        System.out.println("我是一个StaticTest静态代码块");
    }


    public StaticTest() {
        System.out.println("StaticTest构造");
    }
}
