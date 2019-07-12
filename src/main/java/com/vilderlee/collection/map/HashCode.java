package com.vilderlee.collection.map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/14      Create this file
 * </pre>
 */
public class HashCode {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("1231414124");

        System.out.println(stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString());
    }
}
