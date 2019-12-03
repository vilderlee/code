package com.vilderlee.nio.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 功能描述:
 *
 * @package com.vilderlee.nio.buffer
 * @auther vilderlee
 * @date 2019/12/3 10:34 下午
 */
public class ByteBufferTest3 {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("/Users/vilderlee/IdeaProjects/code/src/main/resources/nio.txt");
        FileOutputStream outputStream = new FileOutputStream("/Users/vilderlee/IdeaProjects/code/src/main/resources/nio2.txt");

        FileChannel inputStreamChannel = inputStream.getChannel();
        FileChannel outputStreamChannel = outputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());


    }
}
