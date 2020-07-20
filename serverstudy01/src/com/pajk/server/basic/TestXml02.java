package com.pajk.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestXml02 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // xml java 中有四种解析方式，这里使用SAX方式解析。这是一种流的方式，还有DOM方式
        //步骤：
        // 1. 获取SAX解析工厂方法
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        // 2. 从解析工厂获取解析器
        SAXParser  saxParser = saxParserFactory.newSAXParser();
        // 3. 编写handle
        // 4. 加载文档document ,注册处理器handle
        Persionhandle persionhandle = new Persionhandle();
        // 5. 解析
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/pajk/server/basic/p.xml"),persionhandle);

        // 6.获取数据
        List<Person> persons = persionhandle.getPersons();
        for(Person p:persons){
            System.out.println(p.getName() + "年龄为：" + p.getAge());
        }

    }
}
class Persionhandle extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag; // 存储操作的标签

    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始！！！");
        persons = new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "解析开始");
        if(null!=qName){
            tag = qName;// 开始存储
            if(tag.equals("person")){
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String context = new String(ch,start,length).trim();
//        if(context.length() > 0){
//            System.out.println("内容为：" + context);
//        }else {
//            System.out.println("内容为：null");
//
//        }
        if(null!=tag){ // 处理tag为空的情况
            if(tag.equals("name")){
                person.setName(context);
            }else if(tag.equals("age")){
                if(context.length()>0){
                person.setAge(Integer.valueOf(context));
                }
            }
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "解析结束");
        if(null!=qName){
            if(qName.equals("person")){
                persons.add(person);
            }
        }
        tag = null;// 丢弃tag，避免标签空字符串覆盖前一个tag的值
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束！！！");
    }

    public List<Person> getPersons() {
        return persons;
    }
}
