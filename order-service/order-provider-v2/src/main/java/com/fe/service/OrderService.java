package com.fe.service;

import com.fe.IOrderService;
import com.fe.config.MyRemoteService;

/**
 * @Description OrderService
 * @Author sosuke
 * @Date 2021/8/19 22:01
 */
@MyRemoteService  // 表明这个service是对外提供服务的，会对外发布
public class OrderService implements IOrderService {
    @Override
    public String getOrderList() {
        return "execute getOrderList method";
    }

    @Override
    public String getOrderById(int orderId) {
        return "execute getOrderById method, orderId = " + orderId;
    }
}
