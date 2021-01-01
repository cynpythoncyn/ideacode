package com.pajk.test;

public class FirstJavaClass {

    public static void main(String[] args) {
        /**
         * 1. 数组的声明
         * 2. 给数组分配空间
         * 3. 数组赋值
         *    a) 静态赋值   arrayInt
         *    b) 动态赋值   arrayLong  User[] s
         *    c) 默认赋值   arrayString   默认为null
         */
        int[] arrayInt ={1,2,56};
        long[] arrayLong = new long[5];
        String[] arrayString = new String[5];


        for(int i=0;i<arrayLong.length;i++){
            arrayLong[i] = 10*i;
        }
        for(long a:arrayLong){
            System.out.println("打印："+a);
        }
        User[] s = new User[5];
        User us1 = new User(18,"chenyanan01");
        User us2 = new User(18,"chenyanan02");
        User us3 = new User(18,"chenyanan03");
        s[0] = us1;
        s[1] = us2;
        s[2] = us3;
//        for (User u : s) {
//            System.out.println(u.getName());
//        }
        for(int i=0;i<s.length;i++){
            if(s[i]!=null){
                System.out.println(s[i].getName());
            }

        }


    }
}

class User{
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
