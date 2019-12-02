package com.vilderlee.netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/26      Create this file
 * </pre>
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private String sendString;

    public EchoClientHandler(String sendString) {
        this.sendString = sendString;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 5; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(sendString,
                    CharsetUtil.UTF_8));
        }


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuffer = (ByteBuf) msg;
        String string = byteBuffer.toString(CharsetUtil.UTF_8);
        System.out.println("客户端接收到了："+string);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
            Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
