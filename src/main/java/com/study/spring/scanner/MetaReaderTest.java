package com.study.spring.scanner;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/16      Create this file
 * </pre>
 */
public class MetaReaderTest {

    public static void main(String[] args) throws IOException {
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        //获取某个类的元数据类型
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader("com.study.spring.scanner"
                + ".ScanTestBean2");
        //注解元数据类型
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //；类元数据类型
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

    }

}
