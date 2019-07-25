package com.vilderlee.rpc;

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
public class Provider {

    private static final String CONFIG = "LocalServer.config";
    private Integer port;
    private Server server;

    /**
     * 服务暴露
     */
    private void export(Object object) throws Exception {
        URL url = getClass().getClassLoader().getResource(CONFIG);
        if (null == url) {
            throw new Exception("This file is not empty!");
        }
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(url.getFile())) {
            properties.load(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        port = Integer.valueOf(properties.getProperty("port"));

        server = new Server(port,object);
        server.start();

    }

    public static void main(String[] args) throws Exception {
        Provider service = new Provider();
        service.export(new HelloServiceImpl());;
    }
}
