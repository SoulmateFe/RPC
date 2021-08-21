package com.fe.rpcproxy;

import com.fe.conf.MyRemoteReference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * @Description ReferenceProxyInvoke
 * @Author sosuke :-)
 * @Date 2021/8/21 16:24
 */
@Component
public class ReferenceProxyInvoke implements BeanPostProcessor {
    @Autowired
    private RemoteInvocationHandler invocationHandler;
    /**
     * 重写前置方法，替换属性值为对应的代理类
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            // 只处理添加了MyRemoteReference 注解的属性
            if (field.isAnnotationPresent(MyRemoteReference.class)) {
                field.setAccessible(true);
                // 生成动态代理类
                Object proxy = Proxy.newProxyInstance(field.getType().getClassLoader(),
                        new Class[]{field.getType()}, invocationHandler);
                try {
                    // 将动态代理类赋值给该属性
                    field.set(bean, proxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}

