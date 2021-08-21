package com.fe.rpcproxy;

import com.fe.config.MyRemoteService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description InitialMediator
 * @Author sosuke :-)
 * @Date 2021/8/21 09:45
 */
@Component
public class InitialMediator implements BeanPostProcessor {

    /**
     * 所有spring管理的bean都会执行此方法
     * 扫描 MyRemoteService 注解并初始化 Mediator 中的map
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        // 只处理添加了MyRemoteService注解的类
        if (clazz.isAnnotationPresent(MyRemoteService.class)) {
            for (Method method : clazz.getDeclaredMethods()) {
                String key = clazz.getInterfaces()[0].getName() +"."+ method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.map.put(key, beanMethod);
            }
        }
        return bean;
    }
}
