package com.vilderlee.socket;

import com.study.mybatis.User;
import com.study.mybatis.utils.FlagEnum;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class SocketTest2 implements Runnable {
    private int anInt = 0;

    public static void main(String[] args) {
        SocketTest2 socketTest = new SocketTest2();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(socketTest);
        executorService.execute(socketTest);
        executorService.execute(socketTest);
        executorService.shutdown();
    }

    @Override public void run() {
        try (Socket socket = new Socket("localhost", 8089);
                OutputStream outputStream = socket.getOutputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            User user = new User(String.valueOf(anInt), "lichao", FlagEnum.FLAG_TRUE, "CHN");
            objectOutputStream.writeObject(user);
            outputStream.write(byteArrayOutputStream.toByteArray());
            InputStream inputStream = socket.getInputStream();
            int i = 0;
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ((inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes,"utf-8"));
            }

            System.out.println(sb.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
