package org.example;

public class Dog implements Animal {

    String name;

    Dog(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats bones");
    }
}
