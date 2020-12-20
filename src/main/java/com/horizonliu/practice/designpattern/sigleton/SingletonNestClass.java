package com.horizonliu.practice.designpattern.sigleton;

/**
 * 单例模式 -- 懒汉模式，使用时才加载
 * 利用静态内部类实现
 *
 * @author horizonliu
 * @date 2020/10/17 6:18 下午
 */
public class SingletonNestClass {

    private SingletonNestClass() {

    }

    private static SingletonNestClass getInstance() {
        return InnerClass.instance;
    }

    /**
     * 静态内部类的加载时机：参考博客 https://www.cnblogs.com/zouxiangzhongyan/p/10762540.html
     * 静态内部类和非静态内部类一样，都不会因为外部内的加载而加载，只在使用时加载，这也说明了为什么此种实现方式是懒汉模式。
     * 不过在加载静态内部类的过程中也会加载外部类。
     */
    private static class InnerClass {
        private static final SingletonNestClass instance = new SingletonNestClass();
    }

}
