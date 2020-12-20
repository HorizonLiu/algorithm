package com.horizonliu.practice.designpattern.sigleton;

/**
 * 单例模式
 * 懒汉模式，在获取实例的时候才初始化
 *
 * @author horizonliu
 * @date 2020/10/17 5:53 下午
 */
public class SingletonLazy {

    /**
     * 声明为私有静态，确保一个类只有一个实例
     */
    private static SingletonLazy instance = null;

    /**
     * 构造函数定义为私有，确保外部无法调用创建新的类
     */
    private SingletonLazy() {

    }

    /**
     * 获取实例 -- 创建实例前先检查实例是否已经初始化，若是，直接返回；否则创建
     * 采用synchronized确保多线程安全，但每次获取实例都要加锁，对效率造成影响。
     * 因此也就有了下面的getInstance2()方法，只有当实例为空的时候才加锁
     *
     * @return
     */
    private static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 获取实例
     * 采用双重检查机制，只在instance未初始化时加锁，提高效率
     *
     * @return
     */
    private static SingletonLazy getInstance2() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
