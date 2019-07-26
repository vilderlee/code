package com.study.spring.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 功能描述:
 *
 * @package com.study.spring.importselector
 * @auther vilderlee
 * @date 2019-06-29 22:38
 */
public class ColorImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.study.spring.importselector.Red"};
    }
}
