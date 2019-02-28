package com.vilderlee.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/12      Create this file
 * </pre>
 */
public class Server {

    public static void main(String[] args) throws IOException {

        try (Selector selector = Selector.open(); ServerSocketChannel ssc = ServerSocketChannel.open();) {
            ssc.socket().bind(new InetSocketAddress(8090));
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true) {
                Iterator iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    if (key.isAcceptable()) {
                        accept(key);
//                        sayHello();
                    }


                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(key.selector(), SelectionKey.OP_READ);

    }



    private static void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.register(key.selector(), SelectionKey.OP_ACCEPT);

    }
}
