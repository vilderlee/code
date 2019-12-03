package com.vilderlee.nio.reactor.basic;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

final class Handler implements Runnable {

    final SocketChannel socketChannel;
    final SelectionKey selectionKey;

    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    static final int READING = 0, SENDING = 1, CLOSE = -1;
    int state = READING;

    StringBuffer stringBuffer;

    public Handler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        selectionKey = this.socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            } else if (state == CLOSE) {
                close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void read() throws IOException {
        if (inputIsComplete()) {
            process();
        }
    }

    private boolean inputIsComplete() throws IOException {
        int read;

        while (true) {
            input.clear();
            read = socketChannel.read(input);
            if (read == -1) {
                return true;
            }
            input.flip();
            Charset charset = Charset.defaultCharset();
            char[] bytes = charset.decode(input).array();
            stringBuffer = new StringBuffer(new String(bytes));
            System.out.println("Receive Message-->" + stringBuffer.toString());

        }
    }

    private void process() {
        if (!"close".equals(stringBuffer.toString())) {
            String response = "Reply:" + stringBuffer.toString();
            System.out.println("Response Message-->" + response);
            output.put(response.getBytes());
            state = SENDING;
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        } else {
            state = CLOSE;
        }
    }

    private void send() throws IOException {
        output.flip();
        socketChannel.write(output);
        state = READING;
        selectionKey.interestOps(SelectionKey.OP_READ);
        output.clear();
    }


    private void close() throws IOException {
        socketChannel.close();
    }
}

