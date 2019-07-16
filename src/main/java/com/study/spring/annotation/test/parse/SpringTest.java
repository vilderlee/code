package com.study.spring.annotation.test.parse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/16      Create this file
 * </pre>
 */
public class SpringTest {
    public static void main(String[] args) throws IOException {
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader reader = metadataReaderFactory.getMetadataReader(Test3.class.getName());

        AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();

        Set<String> set = annotationMetadata.getAnnotationTypes();

        set.forEach((annotation) -> {
            Set<String> annotationTypes = annotationMetadata.getMetaAnnotationTypes(annotation);
            annotationTypes.forEach(System.out::println);
        });

        //        ((ClassPathXmlApplicationContext) context).start();
        System.in.read();
    }
}
