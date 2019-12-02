package com.vilderlee.nio.reactor.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 类说明:
 * 按照DougLee的说法:每一个网络请求都由以下五个事件组成：
 * 1.Read Request
 * 2.Decode Request
 * 3.Process Service
 * 4.Encode Reply
 * 5.Send Reply
 * 每一个Handler在个自的线程里去处理这五个事件。
 * Reactor单线程版本：
 * 1.Reactor 中包含一个acceptor用于接收分发（dispatcher）请求 Read 、 Send
 * 2.
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/12/2      Create this file
 * </pre>
 */
public class Reactor implements Runnable {

    private ServerSocketChannel serverSocket;
    private Selector selector;

    /**
     * setUp Reactor类 只负责处理连接处理
     *
     * @param port
     * @throws IOException
     */
    public Reactor(int port) throws IOException {

        //        SelectorProvider provider = SelectorProvider.provider();
        //        provider.openServerSocketChannel();
        // 创建ServerSocketChannel对象
        serverSocket = ServerSocketChannel.open();

        //        SelectorProvider provider = SelectorProvider.provider();
        //        provider.openSelector();
        // 创建Selector对象
        selector = Selector.open();
        //  绑定端口，并设置非阻塞方式
        serverSocket.bind(new InetSocketAddress(port)).configureBlocking(false);
        //  获取SelectionKey
        SelectionKey selectionKey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        //  内置一个对象
        selectionKey.attach(new Acceptor());
    }

    /**
     * EventLoop
     */
    @Override public void run() {
        try {
            while (true) {
                //selector开始轮循
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    dispatcher(iterator.next());
                }
                selectionKeys.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatcher(SelectionKey key) {
        //第一次轮循时，关注的事件是Accept，SelectionKey的内置对象为Acceptor；
        //第二次之后的轮循时，已经变成了Handler对象里面的构建的Handler。
        Runnable runnable = (Runnable) key.attachment();
        runnable.run();
    }

    private class Acceptor implements Runnable {

        @Override public void run() {
            try {
                //  ServerSocketChannel#accept()，这个方法获取一个连接，该方法是阻塞的，
                //  通过Selector#wakeup()去唤醒selector继续轮循。这样就将连接跟数据处理分隔了
                SocketChannel socketChannel = serverSocket.accept();
                if (socketChannel != null) {
                    new Handler(selector, socketChannel);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(9999);
        new Thread(reactor).start();
    }
}
