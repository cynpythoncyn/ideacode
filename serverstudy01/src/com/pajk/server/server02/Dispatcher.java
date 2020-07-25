package com.pajk.server.server02;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable{

    private Socket client;
    private RequestTest requestTest;
    private ResponseTest responseTest;

    public Dispatcher(Socket client){
        this.client = client;
        try {
            // 获取请求协议
            // 返回响应内容
            requestTest = new RequestTest(client);
            responseTest = new ResponseTest(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        try {
            ServletInterface servlet = WebApp.getServletFormUrl(requestTest.getUrl());

            if (null != servlet) {
                servlet.service(requestTest, responseTest);
                responseTest.pushToBrower(200);
            } else {
                System.out.println("错误的页面");
                responseTest.pushToBrower(404);
            }
        }catch (Exception e){
            try {
                responseTest.pushToBrower(500);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        release();
    }

    /**
     * 释放资源
     */
    private void release(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
