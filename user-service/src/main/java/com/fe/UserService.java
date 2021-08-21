package com.fe;

/**
 * @Description UserService
 * @Author sosuke
 * @Date 2021/8/19 22:02
 */
public class UserService {

    /**
     * 通过代理类来远程调用远端服务
     * @param args
     */
    public static void main(String[] args) {
        RpcProxyClient proxyClient = new RpcProxyClient();

        IOrderService orderService = proxyClient.clientProxy(IOrderService.class, "localhost", 8088);
        System.out.println(orderService.getOrderList());
        System.out.println(orderService.getOrderById(133));

        ITestService testService = proxyClient.clientProxy(ITestService.class, "localhost", 8088);
        System.out.println(testService.sayHello("sosuke"));
    }
}
