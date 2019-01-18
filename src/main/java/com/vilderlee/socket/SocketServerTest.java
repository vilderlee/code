package com.vilderlee.socket;

import org.springframework.util.StopWatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class SocketServerTest implements Runnable {

    private Socket socket;

    public SocketServerTest(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8089);
            ExecutorService executorService = Executors.newFixedThreadPool(5);

            while (true) {
                executorService.execute(new SocketServerTest(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void run() {
        Object object;
        try (InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream()) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            object = objectInputStream.readObject();
            System.out.println("----------------------------------" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(20);
            System.out.println(object);
            stopWatch.stop();

            System.out.println(stopWatch.getLastTaskTimeMillis());

            outputStream.write("收到了".getBytes());
        } catch (Exception e) {

        }
    }
}
