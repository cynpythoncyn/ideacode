package com.pajk.server.server02;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class WebApp {

    private static WebContext webContext;

    static{
        try{
            /**
        1.获取SAX解析工厂方法
        2.从工厂方法中获取解析器
        3.编写处理器
        4.加载文档，注册处理器
        5.解析
        6.获取数据
         */
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            WebHandleTest webHandleTest = new WebHandleTest();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/pajk/server/server02/web01.xml"),webHandleTest);
            // 获取数据

            webContext = new WebContext(webHandleTest.getEntityTests(),webHandleTest.getMappingTests());
        }catch (Exception e){
            System.out.println("解析配置文件错误！！！！！");

        }
    }

    /**
     * 通过配置文件获取对应的servlet
     * @param url
     * @return
     */

    public static ServletInterface getServletFormUrl(String url){
        // 假设 输入/login
        String className = webContext.getClz("/" + url);
        try {
            Class clz = Class.forName(className);
            ServletInterface ser = (ServletInterface)clz.getConstructor().newInstance();
            return ser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
