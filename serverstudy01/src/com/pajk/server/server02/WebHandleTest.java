package com.pajk.server.server02;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * xml文件的处理器
 */

public class WebHandleTest extends DefaultHandler {
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
