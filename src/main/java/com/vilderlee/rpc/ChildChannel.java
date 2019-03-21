package com.vilderlee.rpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.CountDownLatch;

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
public class ChildChannel extends ChannelInboundHandlerAdapter {

    private Object object;
    private CountDownLatch countDownLatch;

    public ChildChannel(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("--->>>客户端已经连接<<<---");
    }

    @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        object = SerialUtils.byteToObject(bytes);
        countDownLatch.countDown();
    }

    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
         ctx.close();
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        System.out.println("信息接收完毕...");
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
