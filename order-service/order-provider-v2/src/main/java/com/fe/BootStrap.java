package com.fe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description BootStrap
 * 添加 @Configuration 将此类作为spring容器，并添加扫描
 * @Author sosuke :-)
 * @Date 2021/8/21 10:05
 */
@Configuration
@ComponentScan("com.fe")
public class BootStrap {
    // 启动 spring 容器
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BootStrap.class);
    }
}
