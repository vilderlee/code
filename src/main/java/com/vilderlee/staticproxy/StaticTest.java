package com.vilderlee.staticproxy;


/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/24      Create this file
 * </pre>
 */
public class StaticTest implements Test {

    private Test test;

    public StaticTest(Test test) {
        this.test = test;
    }

    @Override
    public void test() {
        before();
        test.test();
    }

    private void before() {
        System.out.println("Before Test ！！！");
    }

    public static void main(String[] args) {
        Test test = new TestImpl();
        Test staticTest = new StaticTest(test);
        staticTest.test();
    }
}
