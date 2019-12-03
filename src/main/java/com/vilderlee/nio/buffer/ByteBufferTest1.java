package com.vilderlee.nio.buffer;


import java.nio.ByteBuffer;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/9      Create this file
 * </pre>
 */
public class ByteBufferTest1 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        byteBuffer.put("Hello".getBytes());

        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
//        for (int i = 0; byteBuffer.hasRemaining() ; i++) {
//            bytes[i] = byteBuffer.get();
//        }
//        byteBuffer.flip();
        byteBuffer.get(bytes,0,3);
        System.out.println(new String(bytes));

        byteBuffer.put("lc".getBytes());
        byteBuffer.compact();

        byteBuffer.get(bytes,0,5);
        System.out.println(new String(bytes));

        byteBuffer.position(2).mark().position(4);
    }
}
