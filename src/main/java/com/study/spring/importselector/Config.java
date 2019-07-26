package com.study.spring.importselector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 功能描述:
 *
 * @package com.study.spring.importselector
 * @auther vilderlee
 * @date 2019-06-29 22:36
 */

@Import(ColorImportSelector.class)
//@ComponentScan("com.study.spring.importselector")
public class Config {
}
