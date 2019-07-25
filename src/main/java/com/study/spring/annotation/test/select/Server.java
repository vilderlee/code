package com.study.spring.annotation.test.select;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/12      Create this file
 * </pre>
 */
public interface Server {

    void start();

    void stop();

    enum Type {
        /**
         * http
         */
        HTTP,
        /**
         * tcp
         */
        TCP;
    }
}
