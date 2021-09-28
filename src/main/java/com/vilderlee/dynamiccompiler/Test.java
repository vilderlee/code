package com.vilderlee.dynamiccompiler;


import com.vilderlee.dynamiccompiler.Context;

/**
 * Test
 *
 * @ClassName Test
 * @Description
 * @Author VilderLee
 * @Date 2021/9/27 3:26 下午
 */

public class Test {

    public Context todo(Context context) {
        String name = (String) context.get("name");
        context.put("name", "hello" + name);
        context.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);

        });
        System.out.println(context);
        return context;
    }
}
