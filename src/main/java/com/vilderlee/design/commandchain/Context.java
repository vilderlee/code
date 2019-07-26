package com.vilderlee.design.commandchain;

import java.util.HashMap;

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
public class Context extends HashMap {

    private String txSN;

    private String txCode;

    public String getTxSN() {
        return txSN;
    }

    public void setTxSN(String txSN) {
        this.txSN = txSN;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    @Override public Object get(Object key) {
        return super.get(key);
    }

    @Override public Object put(Object key, Object value) {
        return super.put(key, value);
    }
}
