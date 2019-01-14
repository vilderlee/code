package com.vilderlee.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/14      Create this file
 * </pre>
 */
public class SerializeUtil {

    public static byte[] serialize(Object object) throws Exception {
        byte[] bytes = null;

        if (null == object) {
            return null;
        }

        if (object instanceof Serializable) {

            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                objectOutputStream.writeObject(object);
                bytes = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new Exception("Object not implements Serializable!");
        }

        return bytes;
    }

    public static Object unSerialize(byte[] bytes) {
        Object object = null;
        if (null != bytes && 0 != bytes.length) {
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
                object = objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return object;
    }
}
