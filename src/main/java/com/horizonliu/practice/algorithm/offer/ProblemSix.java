package com.horizonliu.practice.algorithm.offer;

/**
 * 重建二叉树
 *
 * @author horizonliu
 * @date 2020/12/20 5:27 下午
 */
public class ProblemSix {
    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode binaryTreeNode = construct(preOrder, inOrder, 8);
        printBinaryTree(binaryTreeNode);
    }

    private static BinaryTreeNode construct(int[] preOrder, int[] inOrder, int length) {
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        return construct(preOrder, inOrder, 0, length - 1, 0, length - 1);
    }

    /**
     * 根据前序和中序遍历，重建二叉树
     *
     * @return
     */
    private static BinaryTreeNode construct(int[] preOrder, int[] inOrder,
                                            int startPreOrder, int endPreOrder,
                                            int startInOrder, int endInorder) {

        int rootValue = preOrder[startPreOrder];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        // 前序和中序序列中都只有一个数字
        if (startPreOrder == endPreOrder && startInOrder == endInorder) {
            return root;
        }

        // 在中序序列中寻找根节点的位置
        int indexRoot = -1;
        for (int i = startInOrder; i <= endInorder; ++i) {
            if (inOrder[i] == rootValue) {
                indexRoot = i;
                break;
            }
        }
        // 在中序序列中未找到根节点
        if (indexRoot == -1) {
            throw new RuntimeException("无效的序列输入");
        }

        // 左子树长度
        int leftLength = indexRoot - startInOrder;
        if (leftLength > 0) {
            root.setLeftNode(construct(preOrder, inOrder,
                    startPreOrder + 1, startPreOrder + leftLength,
                    startInOrder, indexRoot - 1));
        }

        // 右子树长度
        int rightLength = endInorder - indexRoot;
        if (rightLength > 0) {
            root.setRightNode(construct(preOrder, inOrder,
                    startPreOrder + leftLength + 1, endPreOrder,
                    indexRoot + 1, endInorder));
        }
        return root;
    }

    // 二叉树遍历输出--前序输出
    private static void printBinaryTree(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.getValue());
        printBinaryTree(head.getLeftNode());
        printBinaryTree(head.getRightNode());
    }
}
