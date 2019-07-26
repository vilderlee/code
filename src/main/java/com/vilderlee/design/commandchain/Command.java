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
public interface Command {

    /**
     * 责任链执行发生错误
     */
    boolean BREAK = false;

    /**
     * 责任链执行完成
     */
    boolean COMPLETE = true;

    /**
     * 责任链执行方法
     *
     * @return
     * @throws Exception
     */
    boolean execute(Context context) throws Exception;
}
