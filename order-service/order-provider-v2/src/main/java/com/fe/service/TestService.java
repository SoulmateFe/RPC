package com.fe.service;

import com.fe.ITestService;
import com.fe.config.MyRemoteService;

/**
 * @Description TestService
 * @Author sosuke :-)
 * @Date 2021/8/21 15:46
 */
@MyRemoteService
public class TestService implements ITestService {
    @Override
    public String sayHello(String name) {
        return "execute sayHello method, name = " + name;
    }
}
