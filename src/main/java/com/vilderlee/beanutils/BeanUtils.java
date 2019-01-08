package com.vilderlee.beanutils;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/8      Create this file
 * </pre>
 */
public class BeanUtils {
    public static void springTest2() {
        BeanA ba = new BeanA();
        BeanB bb = new BeanB();
        ba.setName1("ba-name1");
        ba.setName2("ba-name2");
        bb.setName1("bb-name1");
        org.springframework.beans.BeanUtils.copyProperties(ba, bb, "name1");
        System.out.println(bb.getName1());
        System.out.println(bb.getName2());
    }

    public static void apacheTest2() {
        BeanA ba = new BeanA();
        BeanB bb = new BeanB();
        ba.setName1("ba-name1");
        ba.setName2("ba-name2");
        bb.setName1("bb-name1");
        bb.setName2("bb-name2");
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperty(bb, "name1", ba);
        } catch (Throwable t) {
        }
        System.out.println(bb.getName1());
        System.out.println(bb.getName2());
    }

    public static void main(String[] args) {
        BeanUtils.springTest2();
        System.out.println("---------------------------------");
        BeanUtils.apacheTest2();

    }
}
