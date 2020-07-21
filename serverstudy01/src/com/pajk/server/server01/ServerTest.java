package com.pajk.server.server01;

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
            Socket clint = serverSocket.accept();
            System.out.println("一个客户端建立了连接-------");

            // 获取请求协议
            InputStream inputStream = clint.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = inputStream.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);

            // 返回响应
            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("数据响应了");
            content.append("</body>");
            content.append("<html>");
            int size = content.toString().getBytes().length;
            StringBuilder responseInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";
            // 响应头 HTTP/1.1 200 OK
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);

            // 响应行(最后一行存在空格)
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:").append("12314212").append(CRLF);
            responseInfo.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8").append(CRLF);
            responseInfo.append("Content-Length:").append(size).append(CRLF);
            responseInfo.append(CRLF);

            // 响应正文
            responseInfo.append(content.toString());

            // 写入到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clint.getOutputStream()));
            bw.write(responseInfo.toString());
            bw.flush();


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
