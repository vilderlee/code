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
        File file = new File("E:\\redis.txt");
        if (!file.exists()){
            file.createNewFile();
        }else {
            file.delete();
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < 1000000; i++) {
            String string = "SET key" +i + " value" + i + "\n";
            fileWriter.write(string);
        }

        fileWriter.close();
    }



}
