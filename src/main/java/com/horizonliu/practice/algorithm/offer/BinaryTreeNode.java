package com.horizonliu.practice.algorithm.offer;

import lombok.Data;

/**
 * @author horizonliu
 * @date 2020/12/20 5:26 下午
 */
@Data
public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
}
