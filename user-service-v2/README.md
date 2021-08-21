* 将mvn项目改造成 springboot 项目
*   1. 添加springboot 父控
*   2. 添加 web-starter
*   3. 添加启动类
* 通过在`controller`中添加注解的方式来自动生成代理类，并实现远程调用
*   1. 通过 BeanPostProcessor 的前置方法来实现对`MyRemoteReference`注解的扫描
*   2. 通过反射将生成的动态代理赋值给对应的属性
*   3. 通过动态代理的`InvocationHandler`来完成对服务端的远程调用