package com.vilderlee.file;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
//import com.sun.org.apache.bcel.internal.classfile.CodeException;

import java.io.File;
import java.util.Properties;

/**
 * SFTP工具
 *
 * <pre>
 * Modify Information:
 * Author       Date        Description
 * ============ =========== ============================
 * xiaohangyu   2016-04-19  Create this file
 *
 * </pre>
 */
public class SFTPHelper{


    protected String host; // 主机
    protected int port; // 端口
    protected String userName; // 用户名
    protected String password; // 密码
    protected String localPath; // 本地目录
    protected String remotePath; // 远程目录

    public SFTPHelper(String host, int port, String userName, String password, String localPath, String remotePath) {

        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.localPath = localPath;
        this.remotePath = remotePath;
    }
    /**
     * Sftp远程传输某个目录下的文件
     *
     * @param localPath  本地目录
     * @param remotePath 远程目录
     * @throws CodeException codeException
     * @author VilderLee
     */
    public void upload(String localPath, String remotePath) throws Exception {
        File file = new File(localPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null == files || 0 == files.length) {
//                throw new CodeException("2001", "没有可用文件");
            }

            Session session = null;
            ChannelSftp channelSftp = null;
            try {
                JSch jsch = new JSch();
                session = jsch.getSession(userName, host, port);
                session.setPassword(password);

                Properties sessionConfig = new Properties();
                sessionConfig.setProperty("StrictHostKeyChecking", "no");
                session.setConfig(sessionConfig);

                session.connect();

                channelSftp = (ChannelSftp) session.openChannel("sftp");
                channelSftp.connect();

                //在根目录下完成操作
                channelSftp.cd(channelSftp.getHome());

                //防止目录没有，需要层级创建目录
                String[] dirs = remotePath.split("/");
                for (int i = 0; i < dirs.length; i++) {
                    try {
                        channelSftp.cd(dirs[i]);
                    } catch (SftpException e) {
                        if (ChannelSftp.SSH_FX_NO_SUCH_FILE == e.id) {
                            channelSftp.mkdir(dirs[i]);
                            channelSftp.cd(dirs[i]);
                        }
                    }
                }
                for (File item : files) {
                    channelSftp.put(item.getAbsolutePath(), channelSftp.getHome() + remotePath + "/" + item.getName(),
                            ChannelSftp.OVERWRITE);
                    boolean deleteResult = item.delete();
                    if (deleteResult){
//                        logger.info(String.format("文件%s已删除",item.getAbsolutePath()));
                    }else {
//                        logger.info(String.format("文件%s删除失败",item.getAbsolutePath()));
                    }
                }
            } catch (Exception ex) {
//                logger.error(ex.getMessage());
//                throw new CodeException("2001", String.format("SFTP上传失败：%s", ex.getMessage()));
            } finally {
                if (session != null && session.isConnected()) {
                    session.disconnect();
                }
                if (channelSftp != null && channelSftp.isConnected()) {
                    channelSftp.disconnect();
                }
            }

        } else {
//            logger.error(String.format("本地目录->%s不是一个目录", localPath));
//            throw new CodeException("2001", String.format("本地目录->%s不是一个目录", localPath));
        }
    }

    public static void main(String[] args) {
        SFTPHelper sftpHelper = new SFTPHelper("39.104.159.18", 22, "root", "lichao.5220246", "", "");
        try {
            sftpHelper.upload("/PayrollService/000020/01", "/PayrollService/000020/01");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
