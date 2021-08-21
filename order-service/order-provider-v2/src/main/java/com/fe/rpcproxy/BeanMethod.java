package com.fe.rpcproxy;

import java.lang.reflect.Method;

/**
 * @Description BeanMethod
 * 对要发布的服务进行组装，哪个bean下的哪个method要对外服务
 * @Author sosuke :-)
 * @Date 2021/8/21 09:20
 */
public class BeanMethod {
    private Object bean;
    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
