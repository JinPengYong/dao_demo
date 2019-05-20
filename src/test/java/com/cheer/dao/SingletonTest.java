package com.cheer.dao;

import org.junit.Test;

// 单例模式是一种设计模式 23种设计模式
// 特点：整个系统里有且仅有一个实例
// 优点：系统的资源得到了很好的重复利用，节省了资源开销
// 使用场景：数据库连接等资源
public class SingletonTest {
    @Test
    public void test() {
        Singleton singleton = Singleton.getInstance();
        //Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton);
        //System.out.println(singleton1);

    }
}

// 单例
class Singleton{
    // (1) 提供一个私有静态实例                           饿汉式
    private static final Singleton INSTANCE = new Singleton();

    // (2) 构造函数私有化
    private Singleton() {
    }

    // (3) 提供一个静态公有方法返回实例
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
