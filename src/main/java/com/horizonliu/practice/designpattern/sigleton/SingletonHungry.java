package com.horizonliu.practice.designpattern.sigleton;

/**
 * 单例模式
 * 饿汉模式：在程序加载时就已经创建好实例
 *
 * @author horizonliu
 * @date 2020/10/17 6:15 下午
 */
public class SingletonHungry {

    /**
     * 用static final修饰，确保变量是类共有，且初始化后不能被修改
     */
    private static final SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {

    }

    public static SingletonHungry getInstance() {
        return instance;
    }

}
