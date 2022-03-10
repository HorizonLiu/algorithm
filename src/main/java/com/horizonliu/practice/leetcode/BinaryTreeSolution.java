package com.horizonliu.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树相关问题主类
 *
 * @author horizonliu
 * @date 2021/12/29 5:12 下午
 */
public class BinaryTreeSolution {

    /**
     * 树的深度
     */
    private int depth = 0;

    /**
     * 求二叉树的深度 -- 后序遍历
     *
     * @param root 树的根节点
     * @return
     */
    public int maxDepthBack(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthBack(root.getLeft());
        int rightDepth = maxDepthBack(root.getRight());
        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 求二叉树的深度 -- 前序遍历
     * depth 即为树的深度
     *
     * @param root 当前节点
     * @param currDepth 当前节点的深度，树的根节点时初始化为0
     * @return .
     */
    public void maxDepthFront(BinaryNode root, int currDepth) {
        // 叶子节点
        if (root == null) {
            depth = Math.max(depth, currDepth);
            return;
        }
        // 未到叶子节点 -- 当前深度 + 1
        maxDepthFront(root.getLeft(), currDepth + 1);
        maxDepthFront(root.getRight(), currDepth + 1);
    }

    /**
     * 求二叉树的深度 -- 层序遍历
     *
     * @param root 树的根节点
     * @return
     */
    public int maxDepthFloor(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                BinaryNode top = queue.poll();
                if (top.getLeft() != null) {
                    queue.add(top.getLeft());
                }
                if (top.getRight() != null) {
                    queue.add(top.getRight());
                }
            }
            depth++;
        }
        return depth;
    }

}
