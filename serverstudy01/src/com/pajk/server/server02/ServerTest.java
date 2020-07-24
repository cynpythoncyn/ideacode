package com.pajk.server.server02;

import java.io.IOException;
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
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接-------");
            // 获取请求协议
            RequestTest requestTest = new RequestTest(client);
            // 返回响应内容
            ResponseTest responseTest = new ResponseTest(client);
            ServletInterface servlet = null;
            if(requestTest.getUrl().equals("login")){
                servlet = new LoginServlet();
                servlet.service(requestTest,responseTest);
            }else if(requestTest.getUrl().equals("reg")){
                servlet = new RegisterServlet();
                servlet.service(requestTest,responseTest);
            }

            // 关注了状态码
            responseTest.pushToBrower(200);

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
