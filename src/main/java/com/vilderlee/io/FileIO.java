package com.vilderlee.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/22      Create this file
 * </pre>
 */
public class FileIO {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\redis/redis.txt");
        file.delete();

        File file1 = file.getParentFile();
        if (file1.isDirectory()){
            file1.delete();
        }
    }



}
