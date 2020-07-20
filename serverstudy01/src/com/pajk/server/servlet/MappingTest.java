package com.pajk.server.servlet;

import java.util.HashSet;
import java.util.Set;

public class MappingTest {
    private String name;
    private Set<String> urlPatterns;

    public MappingTest() {
        urlPatterns = new HashSet<String>();
    }

    public Set<String> getUrlPatterns() {
        return urlPatterns;
    }

    public void setUrlPatterns(Set<String> urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPattern(String pattern){
        this.urlPatterns.add(pattern);
    }

}
