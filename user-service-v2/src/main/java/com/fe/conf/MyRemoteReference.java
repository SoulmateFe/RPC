package com.fe.conf;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description MyRemoteReference
 * 被此注解标记的属性会自动生成代理类来完成远程调用
 * @Author sosuke :-)
 * @Date 2021/8/21 16:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MyRemoteReference {
}
