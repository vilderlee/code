package com.vilderlee.rpc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

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
public class Service {

    private static final String CONFIG = "LocalServer.config";
    private final String hostname;
    private final Integer port;

    public Service() throws Exception {
        URL url = getClass().getClassLoader().getResource(CONFIG);
        if (null == url) {
            throw new Exception("This file is not empty!");
        }
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(url.getFile());) {
            properties.load(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        hostname = properties.getProperty("hostname");
        port = Integer.valueOf(properties.getProperty("port"));
    }

    /**
     * 服务暴露
     */
    public void export(Class<?> interfaceClass) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        Service service = new Service();
        service.export(HelloService.class);
    }
}
