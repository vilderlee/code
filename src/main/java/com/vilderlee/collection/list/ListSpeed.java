package com.vilderlee.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/10      Create this file
 * </pre>
 */
public class ListSpeed {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        //1428
        //        list.forEach(System.out::println);

        //461 32314
//                Iterator iterator = list.iterator();
//                while (iterator.hasNext()){
//                    if (iterator.next().equals(500)){
//                        try {
//                            throw new Exception("this is a error");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            continue;
//                        }
//                    }
//                    System.out.println(iterator.next());
//                }

        //545 32985
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i));
//                }

        //626
        //38233
        for (int i : list) {
            System.out.println(i);
            if (i==500){
                try {
                    throw new Exception("this is a error");
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
