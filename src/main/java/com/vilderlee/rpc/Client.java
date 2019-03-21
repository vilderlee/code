package com.vilderlee.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/21      Create this file
 * </pre>
 */
public class Client {

    private Channel channel;
    private ChannelHandler channelHandler;

    public Client(ChannelHandler channelHandler) {
        this.channelHandler = channelHandler;
    }

    public void connection() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(channelHandler);
            }
        });

        channel = bootstrap.connect("127.0.0.1", 9999).sync().channel();
    }

    public void write(URL url) {
        byte[] bytes = SerialUtils.objectToBytes(url);
        ByteBuf byteBuf = Unpooled.copiedBuffer(bytes);
        channel.writeAndFlush(byteBuf);
    }

    public void close() {
        channel.close();
    }

}
