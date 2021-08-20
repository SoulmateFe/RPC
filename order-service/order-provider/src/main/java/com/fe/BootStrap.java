package com.fe;

/**
 * @Description BootStrap
 * @Author sosuke
 * @Date 2021/8/20 20:15
 */
public class BootStrap {
    /**
     * 手动发布服务接口
     * @param args
     */
    public static void main(String[] args) {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publish(new OrderService(), 8088);
    }
}
