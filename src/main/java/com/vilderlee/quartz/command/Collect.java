package com.vilderlee.quartz.command;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/29      Create this file
 * </pre>
 */
@Service("collect")
public class Collect extends AbstractCommand{

    @Override
    public void execute(int step) {
        System.out.println(step);
    }
}
