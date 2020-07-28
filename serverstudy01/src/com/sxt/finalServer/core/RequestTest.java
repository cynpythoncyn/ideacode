package com.sxt.finalServer.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

public class RequestTest {
    private String requestInfo;

    private String method;
    private String url;
    private String queryInfo;
    private final String CRLF = "\r\n";

    // 存储参数
    private Map<String, List<String>> parameterMap;

    // 构造器相互调用,待理解
    public RequestTest(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public RequestTest(InputStream inputStream){
        parameterMap = new HashMap<String, List<String>>();

        // 获取请求协议，并打印出来
        byte[] datas = new byte[1024*1024*200];
        int len;
        try {
            len = inputStream.read(datas);
            this.requestInfo = new String(datas,0,len);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        // 调用分解请求信息方法
        parseRequestInfo();
    }

    // 分解请求信息
    public void parseRequestInfo(){
        System.out.println("分解请求信息requestInfo---------------");
        System.out.println(requestInfo);
        // 1.获取请求方法 method
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
        // 2.获取请求URL
        int startIdx = this.requestInfo.indexOf("/") + 1;
        int endIdx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startIdx,endIdx).trim();
        // 获取？号的位置
        int queryIdx = this.url.indexOf("?");
        if(queryIdx >= 0){
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            queryInfo = urlArray[1];
            System.out.println(this.url);
            System.out.println(queryInfo);
        }
        // 获取post请求中的请求参数
        if(method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if(null==queryInfo){
                queryInfo = qStr;
            }else{
                queryInfo += "&"+qStr;
            }
        }
        queryInfo = null==queryInfo?"":queryInfo;
        // 请求参数转成MAP,格式：fav=12&fav=34&uname=chenyanan&age=18&others=
        convertMap();

    }
    private void convertMap(){
        // 分割字符串 已 &
        String[] keyValues = this.queryInfo.split("&");
        for(String str:keyValues){
            //再次分割字符串 已 = 号
            String[] kv = str.split("=");
            kv = Arrays.copyOf(kv,2);
            // 获取key和value
            String key = kv[0];
            String value = kv[1]==null?null:decodeChinese(kv[1],"utf-8");
            // 存储到MAP中
            if(!parameterMap.containsKey(key)){
                parameterMap.put(key,new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }

    public String[] getParameterValues(String key){
        List<String> values = this.parameterMap.get(key);
        if(null==values || values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }

    public String getParameter(String key){
        String[] values = getParameterValues(key);
        return values==null?null:values[0];
    }
    // 处理参数value上的中文乱码
    private String decodeChinese(String value,String enc){

        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryInfo() {
        return queryInfo;
    }
}
