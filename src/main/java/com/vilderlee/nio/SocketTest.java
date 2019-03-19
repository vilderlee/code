package com.vilderlee.nio;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/15      Create this file
 * </pre>
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[1024];
        inputStream.read(bytes);

        System.out.println(new String(bytes));
    }
}
