package com.vilderlee.nio.netty;

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
@io.netty.channel.ChannelHandler.Sharable
public class MyChildHander extends ChannelInboundHandlerAdapter {

    @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuffer = (ByteBuf) msg;
        String string = byteBuffer.toString(CharsetUtil.UTF_8);
        System.out.println(string);

        ctx.writeAndFlush(Unpooled.copiedBuffer("OK!",
                CharsetUtil.UTF_8));
    }

    @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
