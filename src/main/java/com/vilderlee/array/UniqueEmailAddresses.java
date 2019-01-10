package com.vilderlee.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/11/9      Create this file
 * </pre>
 */
public class UniqueEmailAddresses {
    public static String[] numUniqueEmails(String[] emails) {
        Set exportEmails = new HashSet();

        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            int atLocation = email.indexOf("@");
            String localName = email.substring(0, atLocation);

            StringBuffer stringBuffer = new StringBuffer();
            if (localName.contains(".")) {
                String[] tempArray = localName.split("\\.");

                for (String temp : tempArray) {
                    stringBuffer.append(temp);
                }
            } else {

            }

            String realEmail = null;
            if (stringBuffer.toString().contains("+")) {

                String temp = stringBuffer.toString();
                String[] tempArray = temp.split("\\+");
                realEmail = tempArray[0];
            }

            exportEmails.add(realEmail + email.substring(atLocation, email.length()));

        }

        return (String[]) exportEmails.toArray(new String[exportEmails.size()]);
    }

    public static void main(String[] args) {
        String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" };
        String[] exportEmails = UniqueEmailAddresses.numUniqueEmails(emails);
        for (String str : exportEmails) {
            System.out.println(str);
        }

    }

}
