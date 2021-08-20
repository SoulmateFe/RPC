package com.fe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Description RemoteInvocationHandler
 * @Author sosuke
 * @Date 2021/8/19 22:08
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 建立远程连接
        RpcNetTransPort rpcNetTransPort = new RpcNetTransPort(host, port);

        // 发送请求
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setTypes(method.getParameterTypes());
        rpcRequest.setArgs(args);
        return rpcNetTransPort.send(rpcRequest);
    }
}
