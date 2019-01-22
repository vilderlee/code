package com.vilderlee.search.lucene;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/22      Create this file
 * </pre>
 */
public class FileText {

    public FileText() {
    }

    public FileText(String fileName, String fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    private String fileName;
    private String fileSize;
    private String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override public String toString() {
        return "FileText{" + "fileName='" + fileName + '\'' + ", fileSize='" + fileSize + '\'' + ", filePath='" + filePath + '\'' + '}';
    }
}
