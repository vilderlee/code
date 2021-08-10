//package com.vilderlee.netty.http;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.handler.codec.http.DefaultHttpResponse;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.handler.codec.http.HttpHeaders;
//import io.netty.handler.codec.http.HttpMethod;
//import io.netty.handler.codec.http.HttpResponse;
//import io.netty.handler.codec.http.HttpResponseStatus;
//import io.netty.handler.codec.http.HttpVersion;
//import io.netty.handler.codec.protobuf.ProtobufDecoder;
//import org.springframework.util.StringUtils;
//
//import java.io.File;
//import java.io.RandomAccessFile;
//
//import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
//import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
//import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
//import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
//import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
//import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
//import static io.netty.handler.codec.http.HttpResponseStatus.OK;
//import static io.netty.handler.codec.rtsp.RtspHeaders.Names.CONNECTION;
//import static org.springframework.amqp.support.AmqpHeaders.CONTENT_TYPE;
//
///**
// * 类说明:
// *
// * <pre>
// * Modify Information:
// * Author        Date          Description
// * ============ ============= ============================
// * VilderLee    2019/9/2      Create this file
// * </pre>
// */
//public class HttpFilServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
//
//    @Override protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
//        if (request.getDecoderResult().isSuccess()) {
//            sendError(ctx, BAD_REQUEST);
//            return;
//        }
//
//        if (request.getMethod() != HttpMethod.GET) {
//            sendError(ctx, METHOD_NOT_ALLOWED);
//            return;
//        }
//
//        final String uri = request.getUri();
//        final String path = sanitizePath(uri);
//
//        if (StringUtils.isEmpty(path)) {
//            sendError(ctx, FORBIDDEN);
//            return;
//        }
//
//        File file = new File(path);
//        if (file.isHidden() || !file.exists()) {
//            sendError(ctx, NOT_FOUND);
//            return;
//        }
//
//        if (!file.isFile()) {
//            sendError(ctx, FORBIDDEN);
//            return;
//        }
//
//        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
//        long fileLength = randomAccessFile.length();
//
//        HttpResponse httpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, OK);
//        setContentLength(httpResponse, fileLength);
//        setContentTypeHeader(httpResponse, file);
//
//        if (isKeepAlive(request)){
//            httpResponse.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
//        }
//
//        ctx.writeAndFlush(httpResponse);
//
//
//    }
//
//    private void setContentTypeHeader(HttpResponse httpResponse, File files) {
//        httpResponse.headers().set(CONTENT_TYPE, "text/html;charset=UTF-8");
//        StringBuilder string = new StringBuilder();
//        string.append("<li>链接：<a href='../\'>..</a></li>\r\n");
//        for (File file :files.listFiles()){
//            string.append("<li>链接：<a href='../\'>..</a></li>\r\n");
//        }
//    }
//
//    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus badRequest) {
//    }
//
//}
