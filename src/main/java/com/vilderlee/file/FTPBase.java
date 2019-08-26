package com.vilderlee.file;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * (S)FTP基类
 * 
 * <pre>
 * Modify Information:
 * Author       Date        Description
 * ============ =========== ============================
 * chenchao     2016-05-04  Create this file
 * 
 * </pre>
 */
public abstract class FTPBase {

//    protected static final Logger logger = Logger.getLogger("system");

    protected String host; // 主机
    protected int port; // 端口
    protected String userName; // 用户名
    protected String password; // 密码
    protected String localPath; // 本地目录
    protected String remotePath; // 远程目录

    public FTPBase(String host, int port, String userName, String password, String localPath, String remotePath) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.localPath = localPath;
        this.remotePath = remotePath;
    }

    public abstract void upload(List<String> list) throws Exception;

}
