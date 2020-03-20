package com.gtools.algorithm.jdk.nio;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author ghy
 * @Date 2020/3/9 10:56
 */
public class SocketService {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8881);
        System.out.println("启动服务器...");
        while (true) {
            Socket s = serverSocket.accept();
            System.out.println("客户端：" + s.getInetAddress().getHostAddress() + "已经连接到服务器.");

            new Thread(() -> {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    while (true) {
                        System.out.println(br.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
