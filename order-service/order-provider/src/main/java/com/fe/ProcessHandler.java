package com.fe;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Description ProcessHandler
 * @Author sosuke
 * @Date 2021/8/20 06:49
 */
public class ProcessHandler implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ) {

            // 反序列化来读取客户端请求
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            // 反射方式调用对应方法
            Object result = reflectInvoke(rpcRequest);
            System.out.println("服务端执行结果："+ result);
            // 返回结果给客户端
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射进行服务的调用
     * @param rpcRequest
     * @return
     * @throws Exception
     */
    private Object reflectInvoke(RpcRequest rpcRequest) throws Exception {
        // 加载Class
        Class<?> clazz = Class.forName(rpcRequest.getClassName());
        // 获取对应method
        Method method = clazz.getMethod(rpcRequest.getMethodName(), rpcRequest.getTypes());
        return method.invoke(service, rpcRequest.getArgs());
    }
}
