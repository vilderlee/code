package com.vilderlee.quartz.command;

import lombok.Setter;

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
public abstract class AbstractCommand {

    @Setter
    protected AbstractCommand abstractCommand;

    public abstract void execute(int step);


}
