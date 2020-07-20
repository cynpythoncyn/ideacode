package com.pajk.test;

public interface InterfaceMyFrist {
    int MY_AGE = 100;
    String MY_NAME = "CHENYANAN";
    void eat();
}


class MyClass implements InterfaceMyFrist {

    @Override
    public void eat() {
        System.out.println("实现第一个接口：InterfaceMyFrist");
        System.out.println(MY_AGE);
        System.out.println(MY_NAME);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.eat();
    }
}
