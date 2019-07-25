package com.vilderlee.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/16      Create this file
 * </pre>
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        Collections.synchronizedList(list);

    }
}
