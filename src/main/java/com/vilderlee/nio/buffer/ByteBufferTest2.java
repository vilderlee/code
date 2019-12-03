package com.vilderlee.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 功能描述:
 *
 * @package com.vilderlee.nio.buffer
 * @auther vilderlee
 * @date 2019/12/3 10:25 下午
 */
public class ByteBufferTest2 {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        FileInputStream inputStream = new FileInputStream("/Users/vilderlee/IdeaProjects/code/src/main/resources/datasource.properties");
        FileOutputStream outputStream = new FileOutputStream("/Users/vilderlee/IdeaProjects/code/src/main/resources/nio.txt");

        FileChannel readChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();
        int read = 0;
        while (true) {
            byteBuffer.clear();

            read = readChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }

            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }

        outputChannel.close();
        readChannel.close();
        outputStream.close();
        inputStream.close();
    }
}
