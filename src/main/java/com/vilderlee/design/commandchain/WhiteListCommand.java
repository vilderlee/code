package com.vilderlee.design.commandchain;

import org.springframework.stereotype.Component;

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
@Component
@RiskCommand(RiskName = "11")
public class WhiteListCommand extends AbstractCommand{

    @Override
    public boolean execute(Context context) throws Exception {
        if (checkTxCode(context)){
            System.out.println("white list check");
            return true;
        }

        return false;
    }

    @Override public String getRiskCommandValue() {
        return "10";
    }
}
