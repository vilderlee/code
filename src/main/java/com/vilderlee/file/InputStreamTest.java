package com.vilderlee.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

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
public class InputStreamTest {

    private static final String filePath = "E:\\story.txt";
    private static final String fileOutPath = "E:\\story1.txt";

    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File(filePath));
            InputStreamReader reader = new InputStreamReader(inputStream,"GBK");

            File out = new File(fileOutPath);
            if (out.exists()){
                out.delete();
            }
            OutputStream outputStream = new FileOutputStream(new File(fileOutPath));
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, "GBK");

            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                writer.write(chars,0,len);
                writer.flush();
            }

            reader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
