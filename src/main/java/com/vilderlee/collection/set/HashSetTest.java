package com.vilderlee.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<VerSet> set = new HashSet<>(3);
        Set<Set> ss = new HashSet<>();
        List<Set> sl = new ArrayList<>();
        set.add(new VerSet('1'));
        set.add(new VerSet('2'));

        ss.add(set);
        sl.add(set);

        set.add(new VerSet('3'));

        if (!ss.contains(set)){
            ss.add(set);
        }

        if (!sl.contains(set)){
            sl.add(set);
        }

        System.out.println(ss.size());
        System.out.println(sl.size());
    }
}
