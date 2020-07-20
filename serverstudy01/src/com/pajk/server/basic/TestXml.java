package com.pajk.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class TestXml {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // xml java 中有四种解析方式，这里使用SAX方式解析。这是一种流的方式，还有DOM方式
        //步骤：
        // 1. 获取SAX解析工厂方法
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        // 2. 从解析工厂获取解析器
        SAXParser  saxParser = saxParserFactory.newSAXParser();
        // 3. 编写handle
        // 4. 加载文档document ,注册处理器handle
        PHhandle pHhandle = new PHhandle();
        // 5. 解析
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/pajk/server/basic/p.xml"),pHhandle);
    }
}
class PHhandle extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始！！！");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String context = new String(ch,start,length).trim();
        if(context.length() > 0){
            System.out.println("内容为：" + context);
        }else {
            System.out.println("内容为：null");

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束！！！");
    }
}
