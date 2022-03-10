package com.horizonliu.practice.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author horizonliu
 * @date 2021/5/27 4:39 下午
 */
public class BasicMain {

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list, "kl");
        System.out.println(list);
    }

    /**
     * 泛型方法
     *
     * @param request 请求
     * @param <T> 请求类型
     * @param <R> 响应类型
     * @return
     */
    public static <T, R> R test(Class<T> request) {
        return null;
    }

}
