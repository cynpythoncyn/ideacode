package com.pajk.server.server02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    private ServerSocket serverSocket;

    private boolean isRunning;

    public void start(){

        try {
            isRunning = true;
            serverSocket = new ServerSocket(8888);
            recevice();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败----------");
        }

    }

    public void recevice(){

        while(isRunning){
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接-------");
                new Thread(new Dispatcher(client)).start();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端接收数据失败");
            }
        }

    }
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ServerTest serverTest = new ServerTest();
        serverTest.start();

    }
}
