package com.fe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description RpcProxyServer
 * @Author sosuke
 * @Date 2021/8/20 06:45
 */
public class RpcProxyServer {
    // 使用线程池来执行IO操作
    private ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 发布服务
     * @param service
     * @param port
     */
    public void publish(Object service, int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // 阻塞方式连接，监听客户端请求
                Socket socket = serverSocket.accept();
                // 通过线程池处理IO操作
                executorService.submit(new ProcessHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
