package com.horizonliu.practice.algorithm.offer;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author horizonliu
 * @date 2020/12/20 6:36 下午
 */
@Data
public class Stack {

    // 留有一个空队列来倒腾

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    // 若有队列不为空，压入元素
    public void push(int value) {
        if (!queue1.isEmpty()) {
            queue1.add(value);
        } else {
            queue2.add(value);
        }
    }

    public int pop() {
        Queue<Integer> nEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

        if (nEmptyQueue.size() == 1) {
            return nEmptyQueue.poll();
        }

        while (nEmptyQueue.size() > 1) {
            emptyQueue.add(nEmptyQueue.poll());
        }

        Integer res = nEmptyQueue.poll();
        return res == null ? 0 : res;
    }

}
