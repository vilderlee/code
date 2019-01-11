package com.vilderlee.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
@SPI
public interface Say {
    void sayHello();
}
