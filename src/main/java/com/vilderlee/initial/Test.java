package com.vilderlee.initial;

import com.study.mybatis.User;
import com.study.mybatis.utils.FlagEnum;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/4      Create this file
 * </pre>
 */
public class Test extends FatherTest{
    static {
        System.out.println("this is Task");
    }
    private static User user = new User("123","lichao", FlagEnum.FLAG_TRUE, "China");

    public Test() {
        System.out.println("this is test");
    }

    public static void main(String[] args) {
        Test test = new Test();
    }

}


class FatherTest{

    static {
        System.out.println("this is FatherTask");
    }

    public FatherTest() {
        System.out.println("this is FatherTest");
    }

}
