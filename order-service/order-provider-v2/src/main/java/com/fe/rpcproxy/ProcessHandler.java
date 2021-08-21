package com.fe.rpcproxy;

import com.fe.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Description ProcessHandler
 * @Author sosuke
 * @Date 2021/8/20 06:49
 */
public class ProcessHandler implements Runnable {

    private Socket socket;

    public ProcessHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ) {

            // 反序列化来读取客户端请求
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            // 内部路由并通过反射调用对应方法
            Mediator mediator = Mediator.getInstance();
            Object result = mediator.processRequest(rpcRequest);
            System.out.println("服务端执行结果："+ result);
            // 返回结果给客户端
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
