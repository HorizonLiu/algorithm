package com.horizonliu.practice.algorithm.offer;

import lombok.Data;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 *
 * @author horizonliu
 * @date 2020/12/20 6:22 下午
 */
@Data
public class Queue {
    // 入队
    private Stack<Integer> s1 = new Stack<>();
    // 出队
    private Stack<Integer> s2 = new Stack<>();

    // 入队
    public void push(int value) {
        s1.push(value);
    }

    // 出队
    public int pop() {

        // s2不为空，返回
        if (!s2.isEmpty()) {
            return s2.pop();
        }

        // s1为空，队列为空
        if (s1.isEmpty()) {
            throw new RuntimeException("队列为空，没有任何元素");
        }

        // s1不为空
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        return s2.pop();
    }
}
