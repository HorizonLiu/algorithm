package com.horizonliu.practice.algorithm.offer;

import java.util.Random;

/**
 * 旋转数组的最小数字
 *
 * @author horizonliu
 * @date 2021/1/3 6:41 下午
 */
public class ProblemEight {

    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 2, 9, 0};
        quickSort(array, array.length, 0, array.length - 1);
        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }
    }

    private static void quickSort(int[] array, int length, int start, int end) {
        if (start == end) {
            return;
        }

        int index = partition(array, length, start, end);
        if (index > start) {
            quickSort(array, length, start, index - 1);
        }
        if (index < end) {
            quickSort(array, length, index + 1, end);
        }
    }


    /**
     * 快速排序--分治
     *
     * @param array  数组
     * @param length 数组长度
     * @param start  开始位置
     * @param end    结束位置
     * @return 用于比较的数：A。 返回排序后，A在数组中的位置
     */
    private static int partition(int[] array, int length, int start, int end) {

        if (array == null || length <= 0 || start < 0 || end >= length) {
            throw new RuntimeException("输入数组不合法");
        }
        Random random = new Random();
        int index = start + random.nextInt(end) % (end - start + 1);
        // 将要比较的数放在最后
        swap(array, index, end);

        // small表示 当前的数中，比A大的数的最小索引
        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (array[index] < array[end]) {
                ++small;
                if (small != index) {
                    swap(array, small, index);
                }
            }
        }
        ++small;
        swap(array, small, end);
        return small;
    }

    /**
     * 交换数组中的两个数
     *
     * @param array 数组
     * @param i     数1的位置
     * @param j     数2的位置
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
