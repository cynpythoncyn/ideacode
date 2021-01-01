package com.pajk.test.collection;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyanan
 * @Date 2020/11/1
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");
        m1.put(4,"four");
        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.get(3));
        System.out.println(m1.get(4));

        Employee emp1 = new Employee(1001,"chenyanan",18);
        Employee emp2 = new Employee(1002,"chenyajun",18);
        Employee emp3 = new Employee(1003,"chenyanan03",18);

        Map<Integer,Employee> map1 = new HashMap<>();
        map1.put(1001,emp1);
        map1.put(1002,emp2);
        map1.put(1003,emp3);
        System.out.println(map1.get(1001).getName());
    }
}
// 雇员类
class Employee{
    int id ;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
