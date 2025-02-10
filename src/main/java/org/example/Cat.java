package org.example;


public class Cat implements Animal {

    String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats fish");
    }
}

