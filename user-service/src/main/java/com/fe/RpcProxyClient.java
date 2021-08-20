package com.fe;

import java.lang.reflect.Proxy;

/**
 * @Description RpcProxyClient
 * @Author sosuke
 * @Date 2021/8/19 22:05
 */
public class RpcProxyClient {

    public <T> T clientProxy(Class<T> interfaceCls, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
