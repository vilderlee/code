package com.study.spring;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/26      Create this file
 * </pre>
 */
public class CollectService extends AbstractTemplate {

    @Override
    protected void doIt(String message) {
        System.out.println("CollectService:" + message);
    }
}
