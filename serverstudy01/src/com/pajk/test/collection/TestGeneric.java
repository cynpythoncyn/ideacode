package com.pajk.test.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<String>();

        mc.set("chenyanan", 0);
//        mc.set(8888, 1);
        System.out.println(mc.get(0));
        System.out.println(mc.get(1));

        List list = new ArrayList();
    }

}

class MyCollection<E> {

    Object[] ob = new Object[5];

    public void set(E e, int index) {
        ob[index] = e;
    }

    public E get(int index) {
        return (E)ob[index];
    }
}
