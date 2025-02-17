package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        // 获取运行时JVM的内存大小
//        Runtime runtime = Runtime.getRuntime();
//        long maxMemory = runtime.maxMemory();
//        System.out.println("Max Memory: " + maxMemory/1024/1024 + " m");
//        System.out.println("Hello world!");
//
//        Thread dogThread = new Thread(() -> {
//            Animal dog = new Dog("Wang Wang");
//            dog.eat();
//            for (int i = 1; i < 50; i++) {
//                System.err.println("Thread1:" + i);
//            }
//        });
//        dogThread.start();
//
//        Thread catThread = new Thread(() -> {
//            Animal cat = new Cat("Miao Miao");
//            cat.eat();
//            for (int i = 1; i < 50; i++) {
//                System.err.println("Thread2:" + i);
//            }
//        });
//        catThread.start();
//
//        for (int i = 1; i < 50; i++) {
//            System.err.println(Thread.currentThread().getName() + i);
//        }
        testDB();
    }

    public static void testDB(){
        DBExample dbExample = new DBExample();
        dbExample.mybatisTest();
        dbExample.mongoTest();
    }
}