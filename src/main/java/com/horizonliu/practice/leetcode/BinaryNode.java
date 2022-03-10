package com.horizonliu.practice.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二叉树节点
 *
 * @author horizonliu
 * @date 2021/12/29 5:10 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryNode {

    private int value;

    private BinaryNode left;

    private BinaryNode right;
}
