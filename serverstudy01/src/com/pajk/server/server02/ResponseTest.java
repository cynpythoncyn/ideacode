package com.pajk.server.server02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class ResponseTest {
    private BufferedWriter bw;
    private StringBuilder responseInfo;
    private StringBuilder content;
    private int size;
    private final String BLANK = " ";
    private final String CRLF = "\r\n";

    private ResponseTest(){
        content = new StringBuilder();
        responseInfo = new StringBuilder();
        size = 0;
    }
    public ResponseTest(Socket client){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            responseInfo = null;
        }
    }


    public ResponseTest(OutputStream os){
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    // 动态响应信息
    public ResponseTest responseTestLn(String info){
        content.append(info).append(CRLF);
        size += (info+CRLF).getBytes().length;
        return this;
    }
    // 数据推送到客户端
    public void pushToBrower(int code) throws IOException {
        if(null == responseInfo){
            code = 500;
        }
        creatHeaderInfo(code);
        responseInfo.append(content.toString());
        bw.write(responseInfo.toString());
        bw.flush();
    }


    private void creatHeaderInfo(int code){
        responseInfo.append("HTTP/1.1").append(BLANK);
        responseInfo.append(code).append(BLANK);

        switch (code){
            case 200:
                responseInfo.append("OK").append(CRLF);
                break;
            case 404:
                responseInfo.append("NOT FOUND").append(CRLF);
                break;
            case 500:
                responseInfo.append("SERVER ERROR").append(CRLF);
                break;
        }

        // 响应行(最后一行存在空格)
        responseInfo.append("Date:").append(new Date()).append(CRLF);
        responseInfo.append("Server:").append("12314212").append(CRLF);
        responseInfo.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8").append(CRLF);
        responseInfo.append("Content-Length:").append(size).append(CRLF);
        responseInfo.append(CRLF);

    }
}
