package com.vilderlee.file;

import java.io.File;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2020/1/2      Create this file
 * </pre>
 */
public class CheckFileExist {

    public static void main(String[] args) {
        File file = new File("D:\\abcd");
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (null == files || files.length == 0) {
                    throw new RuntimeException("No files in the abcd Directory!");
                }else {
                    for (int i = 0; i < files.length; i++) {
                        System.out.println(files[i].getName());
                    }
                }

            } else {
                throw new RuntimeException("abcd is not a Directory!");
            }

        } else {
            throw new RuntimeException("File is not Exist!");
        }

    }
}
