package com.fe.controller;

import com.fe.IOrderService;
import com.fe.ITestService;
import com.fe.conf.MyRemoteReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description UserController
 * @Author sosuke :-)
 * @Date 2021/8/21 16:00
 */
@RestController
public class UserController {
    @MyRemoteReference
    IOrderService orderService;

    @MyRemoteReference
    ITestService testService;

    @GetMapping("/test1")
    public String testRPC1() {
        return orderService.getOrderList();
    }
    @GetMapping("/test2")
    public String testRPC2() {
        return orderService.getOrderById(777);
    }
    @GetMapping("/test3")
    public String testRPC3() {
        return testService.sayHello("sosuke");
    }

}
