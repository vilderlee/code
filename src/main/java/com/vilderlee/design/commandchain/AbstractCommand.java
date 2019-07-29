package com.vilderlee.design.commandchain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
public abstract class AbstractCommand implements Command {

    abstract String getRiskCommandValue();

    public List<RiskTransInfo> getTxCodeList() {
        return (List) Environment.map.get(getRiskCommandValue());
    }

    public RiskCommand.RiskLevelEnum getRiskLevelByTransCode(Context context){

        getTxCodeList().stream().filter(RiskTransInfo->RiskTransInfo.getTxCode().equals(context.getTxCode())).findAny();

        return RiskCommand.RiskLevelEnum.LEVEL_HIGH;
    }


    public boolean checkTxCode(Context context) {
        Set<String> collect = getTxCodeList().stream().map(RiskTransInfo::getTxCode).collect(Collectors.toSet());
        return collect.contains(context.get("txCode"));
    }

}
