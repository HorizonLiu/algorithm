package com.horizonliu.practice.algorithm.offer;

/**
 * 从尾到头打印链表
 *
 * @author horizonliu
 * @date 2020/12/20 5:10 下午
 */
public class ProblemFive {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        head.setNext(p1);
        p1.setNext(p2);

        printListFromTail(head);
    }

    /**
     * 从尾到头打印链表--采用递归（栈）来实现
     *
     * @param head 链表头
     */
    private static void printListFromTail(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.getNext() != null) {
            printListFromTail(head.getNext());
        }
        System.out.println(head.getValue());
    }
}
