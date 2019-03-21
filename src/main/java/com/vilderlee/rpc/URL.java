package com.vilderlee.rpc;

import java.io.Serializable;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/19      Create this file
 * </pre>
 */
public class URL implements Serializable {

    private static final long serialVersionUID = 4963847207885829025L;
    private String interfaceClass;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] objects;

    public String getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(String interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
}
