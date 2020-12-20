package com.horizonliu.practice.algorithm.offer;

/**
 * 用两个栈实现一个队列
 * 用一个栈来来入队，一个来出队
 *
 * @author horizonliu
 * @date 2020/12/20 6:21 下午
 */
public class ProblemSeven {

    public static void main(String[] args) {
//        queueImplWithStack();
        stackImplWithQueue();
    }

    private static void queueImplWithStack() {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    private static void stackImplWithQueue() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}


