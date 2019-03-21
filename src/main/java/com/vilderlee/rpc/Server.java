package com.vilderlee.rpc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.lang.reflect.Method;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/19      Create this file
 * </pre>
 */
public class Server {

    public Server(Integer port, Object object) {
        this.port = port;
        this.object = object;
    }

    private Integer port;
    private EventLoopGroup bossEventLoopGroup;
    private EventLoopGroup workerEventLoopGroup;
    private Object object;

    public void start() {
        try {
            bossEventLoopGroup = new NioEventLoopGroup();
            workerEventLoopGroup = new NioEventLoopGroup();
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossEventLoopGroup, workerEventLoopGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024).
                    //保持连接
                    childOption(ChannelOption.SO_KEEPALIVE, true).
                    childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ChildChannelHandler());
                        }
                    });

            //绑定端口，同步等待成功
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //等待服务器监听端口关闭
            channelFuture.channel().closeFuture().sync();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //优雅退出，释放线程组资源
            bossEventLoopGroup.shutdownGracefully();
            workerEventLoopGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInboundHandlerAdapter {
        @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            //接收到的数据
            URL url = (URL) SerialUtils.byteToObject(bytes);
            //处理以后的数据
            byte[] result = doBusiness(url);
            ByteBuf buf = Unpooled.copiedBuffer(result);
            ctx.writeAndFlush(buf);
        }

        @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }

        public byte[] doBusiness(URL url) {
            byte[] bytes = new byte[1024];
            try {
                //获取参数类型
                Class[] parameterTypes = url.getParameterTypes();
                //获取参数值
                Object[] objects = url.getObjects();
                Method method = object.getClass().getMethod(url.getMethodName(), parameterTypes);

                Object result = method.invoke(object, objects);

                bytes = SerialUtils.objectToBytes(result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return bytes;
        }
    }

}