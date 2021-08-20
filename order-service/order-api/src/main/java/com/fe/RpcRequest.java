package com.fe;

import java.io.Serializable;

/**
 * @Description RpcRequest
 * @Author sosuke
 * @Date 2021/8/20 07:01
 */
public class RpcRequest implements Serializable {
    private String className;
    private String methodName;
    private Class[] types;
    private Object[] args;

    public RpcRequest() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
