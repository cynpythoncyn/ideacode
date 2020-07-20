package com.pajk.test;

public abstract class AbstractAnimal {
    abstract public void shut();

    public void run(){
        System.out.println("动物再跑！！");
    }
}


class Dog extends AbstractAnimal{

    @Override
    public void shut() {
        System.out.println("在叫！！！");
    }
}

class TestAbstractAnimal{
    public static void main(String[] args){
        Dog dog = new Dog();
        dog.shut();
        dog.run();
    }
}
