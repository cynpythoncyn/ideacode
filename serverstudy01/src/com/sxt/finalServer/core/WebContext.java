package com.sxt.finalServer.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
将list数据格式转换成Map格式
 */

public class WebContext {
    private List<EntityTest> entityTests = null;
    private List<MappingTest> mappingTests = null;

    private Map<String,String> entityMap = new HashMap<String,String>();
    private Map<String,String> mappingMap = new HashMap<String, String>();

    public WebContext(List<EntityTest> entityTests, List<MappingTest> mappingTests) {
        this.entityTests = entityTests;
        this.mappingTests = mappingTests;
        // 将entityTest 的list 转换成map
        for(EntityTest entityTest:entityTests){
            entityMap.put(entityTest.getName(),entityTest.getClz());
        }
        // 将mappingTest 的list转换成map
        for(MappingTest mappingTest:mappingTests){
            for(String urlPattern:mappingTest.getUrlPatterns()){
            mappingMap.put(urlPattern,mappingTest.getName());
            }
        }
    }
    // 通过URL 找到对应的类名
    public String getClz(String pattern){
        String name = mappingMap.get(pattern);

        return entityMap.get(name);
    }
}
