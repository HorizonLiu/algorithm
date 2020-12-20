package com.horizonliu.practice.algorithm.offer;

/**
 * 在一个二维数组中m*n，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否有该整数。
 * <p>
 * 思路分析
 * 法一：暴力解决，遍历数组进行比较，时间复杂度O(m*n)
 * 法二：由于数组是按照行/列有序的，可以利用起来。我们可以从左下角或右上角的元素出发进行比较，以左下角为例：
 * 假设元素e==左下角元素，结束，返回true；假设e>左下角元素，则可以排除第一列；假设e<左下角元素，则可以排除最后一行。
 * 按照这种方法执行，每执行一次，元素查找范围缩小一维，最终可确定数组中是否含有该元素。综上，时间复杂度为O(m+n)
 *
 * @author horizonliu
 * @date 2020/10/25 5:44 下午
 */
public class ProblemThree {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9,}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println("find ele: " + findElement(array, 1));
    }


    public static boolean findElement(int[][] array, int ele) {

        // 初始条件判断
        if (array == null
                || array.length <= 0
                || array[0].length <= 0) {
            return false;
        }

        int totalColumn = array[0].length;
        int row = array.length - 1;
        int column = 0;

        while (row >= 0 && column < totalColumn) {
            int tmp = array[row][column];
            if (tmp == ele) {
                return true;
            } else if (tmp < ele) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }

}
