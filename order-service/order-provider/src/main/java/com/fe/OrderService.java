package com.fe;

/**
 * @Description OrderService
 * @Author sosuke
 * @Date 2021/8/19 22:01
 */
public class OrderService implements IOrderService{
    @Override
    public String getOrderList() {
        return "execute getOrderList method";
    }

    @Override
    public String getOrderById(int orderId) {
        return "execute getOrderById method, orderId = " + orderId;
    }
}
