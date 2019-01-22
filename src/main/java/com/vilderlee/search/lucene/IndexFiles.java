package com.vilderlee.search.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/22      Create this file
 * </pre>
 */
public class IndexFiles {

    private IndexWriter indexWriter;

    public IndexFiles() {
    }

    public IndexFiles(String indexPath) {

        try {
            //指定索引库的存放地址
            Directory directory = FSDirectory.open(Paths.get(indexPath));
            //指定一个标准分析器
            Analyzer analyzer = new StandardAnalyzer();
            //保存用于创建IndexWriter的所有配置。
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            //实例化IndexWriter
            indexWriter = new IndexWriter(directory, iwc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 建立索引
     *
     * @param filePath 原始文件/数据地址
     */
    public void createIndex(String filePath) {
        //将文件下面所有的文件全部拿到
        File[] files = new File(filePath).listFiles();

        for (File file : files) {
            //创建Document对象
            Document document = new Document();
            //创建Field对象
            Field fileNameField = new TextField("fileName", file.getName(), Field.Store.YES);
            Field fileSizeField = new TextField("fileSize",  String.valueOf(FileUtils.sizeOf(file)), Field.Store.YES);
            Field filePathField = new TextField("filePath", file.getPath(), Field.Store.YES);
            //将Field对象放入Document中
            document.add(fileNameField);
            document.add(fileSizeField);
            document.add(filePathField);
            try {
                indexWriter.addDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        IndexFiles indexFiles = new IndexFiles("E:\\index\\");
        indexFiles.createIndex("F:\\book\\");
        indexFiles.close();
    }
}
