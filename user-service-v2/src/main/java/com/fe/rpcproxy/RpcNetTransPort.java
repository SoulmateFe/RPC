package com.fe.rpcproxy;

import com.fe.RpcRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Description RpcNetTransPort
 * @Author sosuke
 * @Date 2021/8/20 06:57
 */
public class RpcNetTransPort {
    private String host;
    private int port;

    public RpcNetTransPort(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 通过socket建立连接并发送请求
     * @param rpcRequest
     * @return
     */
    public Object send(RpcRequest rpcRequest) {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ) {

            // 序列化并发送到远端
            oos.writeObject(rpcRequest);
            oos.flush();
            // 读取远端接口返回
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
