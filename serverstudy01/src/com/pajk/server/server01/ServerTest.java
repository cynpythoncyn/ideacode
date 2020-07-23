package com.pajk.server.server01;

import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

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
//            InputStream inputStream = clint.getInputStream();
//            byte[] datas = new byte[1024*1024];
//            int len = inputStream.read(datas);
//            String requestInfo = new String(datas,0,len);
//            System.out.println(requestInfo);
            RequestTest requestTest = new RequestTest(client);
            requestTest.parseRequestInfo();

            // 返回响应内容
            // 关注了内容
            ResponseTest responseTest = new ResponseTest(client);
            responseTest.responseTestLn("<html>");
            responseTest.responseTestLn("<head>");
            responseTest.responseTestLn("<title>");
            responseTest.responseTestLn("服务器响应成功");
            responseTest.responseTestLn("</title>");
            responseTest.responseTestLn("</head>");
            responseTest.responseTestLn("<body>");
            responseTest.responseTestLn("数据响应了");
            responseTest.responseTestLn("</body>");
            responseTest.responseTestLn("<html>");
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
