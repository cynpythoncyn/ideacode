package com.pajk.test.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author chenyanan
 * @Date 2020/11/1
 */
public class TestList {
    public static void main(String[] args) {
        /**
         * vector,线程安全，增删改查效率低。底层实现数组
         * ArrayList, 查询效率高，增删改效率低，线程不安全。底层实现数组
         * LinkedList，增删改效率高，查询效率低，线程不安全。底层实现链表
         */
        Collection<String> collection  =new ArrayList<>();
        System.out.println(collection.size());
        collection.add("chen1");
        collection.add("chen2");
        collection.add("chen3");
        collection.add("chen4");
        for (String a:collection) {
            System.out.println(a);
        }
        System.out.println(collection.size());
    }


}
