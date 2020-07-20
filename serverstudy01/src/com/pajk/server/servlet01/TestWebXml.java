package com.pajk.server.servlet01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TestWebXml {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
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
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/pajk/server/servlet01/web.xml"),webHandleTest);
        // 获取数据

        WebContext webContext = new WebContext(webHandleTest.getEntityTests(),webHandleTest.getMappingTests());
        // 假设 输入/login
        String className = webContext.getClz("/reg");
        Class clz = Class.forName(className);
        ServletInterface ser = (ServletInterface)clz.getConstructor().newInstance();
        System.out.println(ser);
        ser.service();

    }
}

class WebHandleTest extends DefaultHandler {
    private List<EntityTest> entityTests;
    private List<MappingTest> mappingTests;
    private EntityTest entityTest;
    private MappingTest mappingTest;
    private String tag;
    private boolean isMapping = false;
    @Override
    public void startDocument() throws SAXException {
        entityTests = new ArrayList<EntityTest>();
        mappingTests = new ArrayList<MappingTest>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(null!=qName){
            tag = qName;
            if(tag.equals("servlet")){
                entityTest = new EntityTest();
                isMapping = false;
            }else if(tag.equals("servlet-mapping")){
                mappingTest = new MappingTest();
                isMapping = true;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if(null!=tag){
            if(isMapping){
                if(tag.equals("servlet-name")){
                    mappingTest.setName(contents);
                }else if(tag.equals("url-pattern")){
                    mappingTest.addPattern(contents);
                }
            }else{
                if(tag.equals("servlet-name")){
                    entityTest.setName(contents);
                }else if(tag.equals("servlet-class")){
                    entityTest.setClz(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(null!=qName){
            if(qName.equals("servlet")){
                entityTests.add(entityTest);
            }else if(qName.equals("servlet-mapping")){
                mappingTests.add(mappingTest);
            }
        }
        tag = null;

    }


    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束！！！");
    }

    public List<EntityTest> getEntityTests() {
        return entityTests;
    }

    public List<MappingTest> getMappingTests() {
        return mappingTests;
    }
}
