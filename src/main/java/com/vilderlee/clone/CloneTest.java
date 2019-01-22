package com.vilderlee.clone;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //        User user = new User("0001", "VilderLee", "Chinese");
        //        User user1 = user;
        //        user1.setCountry("USA");
        //
        //        System.out.println(user == user1);
        //
        //        User userSoft = user.clone();
        //        System.out.println("浅克隆:" + (user == userSoft));
        //        System.out.println("浅克隆:" + (user.getUserName().hashCode() == userSoft.getUserName().hashCode()));

        String string = "lichao";
        String string1 = new String("lichao");
        System.out.println(string.equals("lichao"));
        System.out.println(string == string1);
        System.out.println(string.hashCode() == string1.hashCode());

    }
}
