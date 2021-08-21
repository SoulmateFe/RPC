package com.fe.rpcproxy;

import com.fe.RpcRequest;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description Mediator 用于存储所有对外发布的服务实例的map集合
 * @Author sosuke :-)
 * @Date 2021/8/21 09:17
 */
public class Mediator {
    // 对于标记了对外发布的类，以方法的全限定名为key进行组装
    public static Map<String, BeanMethod> map = new ConcurrentHashMap<>();
    private volatile static Mediator INSTANCE;

    private Mediator(){}

    public static Mediator getInstance() {
        if (null == INSTANCE) {
            synchronized (Mediator.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Mediator();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 内部路由并通过反射调用对应服务方法
     * @param rpcRequest
     * @return
     * @throws Exception
     */
    public Object processRequest(RpcRequest rpcRequest) {
        String key = rpcRequest.getClassName() + "." + rpcRequest.getMethodName();
        BeanMethod beanMethod = map.get(key);
        if (null == beanMethod) return null;

        Object bean = beanMethod.getBean();
        Method method = beanMethod.getMethod();
        try {
            return method.invoke(bean, rpcRequest.getArgs());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
