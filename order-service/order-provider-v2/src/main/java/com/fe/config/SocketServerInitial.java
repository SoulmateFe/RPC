package com.fe.config;

import com.fe.rpcproxy.RpcProxyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description SocketServerInitial
 * spring 容器启动完成后，会产生 ContextRefreshedEvent 事件
 * @Author sosuke :-)
 * @Date 2021/8/21 09:32
 */
@Component
public class SocketServerInitial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RpcProxyServer rpcProxyServer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        rpcProxyServer.publish(8088);
    }
}
