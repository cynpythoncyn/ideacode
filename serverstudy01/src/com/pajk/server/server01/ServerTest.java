package com.pajk.server.server01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    private ServerSocket serverSocket;

    public void start(){

        try {
            serverSocket = new ServerSocket(8888);
            recevice();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败----------");
        }

    }

    public void recevice(){

        try {
            Socket clint = serverSocket.accept();
            System.out.println("一个客户端建立了连接-------");

            // 获取请求协议
            InputStream content = clint.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = content.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端接收数据失败");
        }

    }

    public void stop(){

    }

    public static void main(String[] args) {
        ServerTest serverTest = new ServerTest();
        serverTest.start();

    }
}
