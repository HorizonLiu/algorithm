package com.horizonliu.practice.algorithm.offer;

import lombok.Data;

/**
 * @author horizonliu
 * @date 2020/12/20 5:11 下午
 */
@Data
public class ListNode {
    private int value;
    private ListNode next;


    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}
