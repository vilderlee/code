package com.study.dispatcher;

import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/12/16      Create this file
 * </pre>
 */
@Component
@DepositMode(depositMode = {20,22,23}, txType = TxTypeEnum.CORE)
public class ZrCorRegBO implements Executor{
    @Override
    public void execute(){
        System.out.println("企业开户！！！");
    }
}
