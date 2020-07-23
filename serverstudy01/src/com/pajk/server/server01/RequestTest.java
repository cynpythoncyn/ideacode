package com.pajk.server.server01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RequestTest {
    private String requestInfo;

    private String method;
    private String url;
    private String queryInfo;
    private final String CRLF = "\r\n";

    // 构造器相互调用,待理解
    public RequestTest(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public RequestTest(InputStream inputStream){
        // 获取请求协议，并打印出来
        byte[] datas = new byte[1024*1024];
        int len;
        try {
            len = inputStream.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    // 分解请求信息
    public void parseRequestInfo(){
        System.out.println("分解请求信息requestInfo---------------");
        System.out.println(requestInfo);
        // 1.获取请求方法 method
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).trim();
        // 2.获取请求URL
        int startIdx = this.requestInfo.indexOf("/") + 1;
        int endIdx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startIdx,endIdx);
        // 获取？号的位置
        int queryIdx = this.url.indexOf("?");
        if(queryIdx>=0){
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            queryInfo = urlArray[1];
            System.out.println(this.url);
            System.out.println(queryInfo);
        }
        // 获取post请求中的请求参数
        if(method.equals("POST")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if(null==queryInfo){
                queryInfo = qStr;
            }else{
                queryInfo += "&uuuu"+qStr;
            }
        }
    }


}
