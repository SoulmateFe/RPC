package com.fe.rpcproxy;

import com.fe.RpcRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description RemoteInvocationHandler
 * @Author sosuke
 * @Date 2021/8/19 22:08
 */
@Component
public class RemoteInvocationHandler implements InvocationHandler {
    @Value("${order.service.host}")
    private String host;
    @Value("${order.service.port}")
    private int port;

    public RemoteInvocationHandler() {
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
