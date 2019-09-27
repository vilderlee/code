package com.vilderlee.nio.nettyhttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/9/2      Create this file
 * </pre>
 */
public class HttpServer {

    public void run(int port, String url) {

        EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workEventLoopGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        try {
            serverBootstrap.group(bossEventLoopGroup, workEventLoopGroup);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                    ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                    ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                    ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                    ch.pipeline().addLast("http-fileServer", new HttpFilServerHandler());

                }
            });

            ChannelFuture sync = serverBootstrap.bind(port).sync();
            System.out.println("服务器已经启动！");
            sync.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            bossEventLoopGroup.shutdownGracefully();
            workEventLoopGroup.shutdownGracefully();
        }

    }
}
