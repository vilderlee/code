package com.vilderlee.rpc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class SerialUtils {

    public static Object byteToObject(byte[] bytes) {

        Object o = new Object();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            o = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return o;
    }

    public static byte[] objectToBytes(Object o) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(o);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
