package com.pajk.server.basic;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /*
        1. 获取Class的三种方式：
        掌握：Class.forName("包名.类名")
        2. 创建对象
        掌握：(MoblieIphone)clz3.getConstructor().newInstance()
         */
        // 1. 对象.getClass()
        MoblieIphone moblieIphone = new MoblieIphone();
        Class clz1 = moblieIphone.getClass();
        System.out.println("第一种方式："+clz1);

        // 2. 类.class
        Class clz2 = MoblieIphone.class;
        System.out.println("第二种方式："+clz2);

        // 3. Class.forName("包名.类名")
        Class clz3 = Class.forName("com.pajk.server.basic.MoblieIphone");
        System.out.println("第三种方式：" + clz3);

        // 开始创建对象
        /* 1.在jdk9以下不推荐使用此方式了
        MoblieIphone moblieIphone3 = (MoblieIphone)clz3.newInstance();
        System.out.println(moblieIphone3);
         */
        // 2. 推荐方式
        MoblieIphone moblieIphone3 = (MoblieIphone)clz3.getConstructor().newInstance();
        System.out.println(moblieIphone3);

    }
}

class MoblieIphone{
    public MoblieIphone(){

    }
}