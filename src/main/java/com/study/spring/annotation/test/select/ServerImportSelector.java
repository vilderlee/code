package com.study.spring.annotation.test.select;

import com.study.spring.annotation.EnableHelloWorld;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/12      Create this file
 * </pre>
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map map = importingClassMetadata.getAnnotationAttributes(EnableHelloWorld.class.getName());
        Server.Type type = (Server.Type) map.get("proxy");
        if (Server.Type.HTTP.equals(type)){
            return new String[]{HttpServer.class.getName()};
        }else {
            return new String[]{TcpServer.class.getName()};

        }


    }
}
