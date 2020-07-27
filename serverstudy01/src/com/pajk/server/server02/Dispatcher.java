package com.pajk.server.server02;

import java.io.IOException;
import java.io.InputStream;
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
            if(null == requestTest.getUrl()||requestTest.getUrl().equals("")){
                String str = getData("com/pajk/server/server02/index.html");
                responseTest.responseTestLn(str);
                responseTest.pushToBrower(200);
                return;
            }
            ServletInterface servlet = WebApp.getServletFormUrl(requestTest.getUrl());

            if (null != servlet) {
                servlet.service(requestTest, responseTest);
                responseTest.pushToBrower(200);
            } else {
                // 返回一个error页面
                String str = getData("com/pajk/server/server02/error.html");
                responseTest.responseTestLn(str);
                responseTest.pushToBrower(404);
            }
        }catch (Exception e){
            try {
                // 直接打印文字
                responseTest.responseTestLn("服务器走失了！！！");
                responseTest.pushToBrower(500);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        release();
    }
    private String getData(String file) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        byte[] car = new byte[1024*1024];
        int len = -1;
        while((len=is.read(car))!=-1){
            String str = new String(car,0,len);
            is.close();
            return str;
        }
        return null;
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
