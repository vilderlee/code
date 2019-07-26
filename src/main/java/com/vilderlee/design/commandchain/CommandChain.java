package com.vilderlee.design.commandchain;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */
public interface CommandChain extends Command{

    void addCommand(Command command);
}
