package com.vilderlee.nio.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
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
public class MultiTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public MultiTimeServer(int port) {
        try {
            //1.开启通道
            serverSocketChannel = ServerSocketChannel.open();
            //2.绑定端口并设置连接模式为非阻塞
            serverSocketChannel.socket().bind(new InetSocketAddress(9999),1024);
            serverSocketChannel.configureBlocking(false);
            //3.创建Selector
            selector = Selector.open();
            //4.将serverSocketChannel注册到selector上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server is Initial in port : " + port);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override public void run() {
        while (true) {
            try {
                selector.select(1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                try {
                    handleKeys(key);
                } catch (Exception ex) {
                    if (key != null) {
                        key.cancel();
                        if (key.channel() != null) {
                            try {
                                key.channel().close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 关闭通道。多路复用器关闭以后，上面注册的channel等资源都会关闭，所以不需要重复释放资源
     */
    public void cloes() {

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleKeys(SelectionKey key) throws IOException {
        if (key.isValid()) {
            //key可以接入
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = ssc.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }

            //key可以读取数据
            if (key.isReadable()) {
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
                    doWrite(socketChannel);
                }
            }
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        String responseMsg = "已收到数据，正在处理中";
        ByteBuffer byteBuffer = ByteBuffer.allocate(responseMsg.getBytes().length);
        byteBuffer.put(responseMsg.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
}
