package com.study.dispatcher;

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
public enum TxTypeEnum {

    INDIVIDUAL("1141","个人开户"),
    CORE("1142", "企业开户")

    ;

    private String txCode;

    private String txName;

    TxTypeEnum(String txCode, String txName) {
        this.txCode = txCode;
        this.txName = txName;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getTxName() {
        return txName;
    }

    public void setTxName(String txName) {
        this.txName = txName;
    }
}
