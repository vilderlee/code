package com.vilderlee.nio.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/14      Create this file
 * </pre>
 */
public class MultiClient implements Runnable {

    private SocketChannel socketChannel;

    private Selector selector;

    private String ip;

    private int port;

    private volatile boolean stop;

    public MultiClient(String ipAddress, int port) {
        this.ip = ipAddress == null ? "127.0.0.1" : ipAddress;
        this.port = port;
        try {
            //1.开启SocketChannel通道
            socketChannel = SocketChannel.open();
            //2.开启IO多路复用器
            selector = Selector.open();
            socketChannel.configureBlocking(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override public void run() {
        try {
            doConnect();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        while (!stop) {
            try {
                selector.select(1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                inputHandle(key);
            }

        }
    }

    private void inputHandle(SelectionKey key) {
        try {
            if (key.isValid()) {
                SocketChannel channel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    if (channel.finishConnect()) {
                        channel.register(selector, SelectionKey.OP_READ);
                        doWrite(channel,"写入数据");
                    }
                }

                if (key.isReadable()){
                    //获取连接的SocketChannel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //建立缓冲区，并设置缓冲区大小
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    //读取数据到缓冲区中
                    int byteNum = socketChannel.read(readBuffer);
                    if (byteNum > 0) {
                        //现将readBuffer复位
                        readBuffer.flip();
                        byte bytes [] = new byte[readBuffer.remaining()];
                        bytes = readBuffer.array();
                        String receiveMsg = new String(bytes, StandardCharsets.UTF_8);
                        System.out.println("服务器端接收到的数据：" + receiveMsg);
                        //回复数据
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void doConnect() throws IOException {
        //3.建立连接
        boolean isConnect = socketChannel.connect(new InetSocketAddress(ip, port));
        if (isConnect) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel,"建立连接");
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel,String requestMsg) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(requestMsg.getBytes().length);
        byteBuffer.put(requestMsg.getBytes());
        byteBuffer.flip();

        socketChannel.write(byteBuffer);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
