package com.vilderlee.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/4      Create this file
 * </pre>
 */
public class ReaderTest {
    private static final String filePath = "E:\\redis.txt";
    private static final String fileOutPath = "E:\\story1.txt";

    public static void main(String[] args) {
        try {
            Reader reader = new FileReader(new File(filePath));
//            BufferedReader bufferedReader = new BufferedReader(reader);
            File out = new File(fileOutPath);
            if (out.exists()){
                out.delete();
            }
            Writer writer = new FileWriter(new File(fileOutPath));

            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars, 0, len);
                writer.flush();
            }

            writer.close();
//            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
