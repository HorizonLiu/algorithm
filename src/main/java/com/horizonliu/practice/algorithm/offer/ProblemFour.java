package com.horizonliu.practice.algorithm.offer;

/**
 * 请实现一个函数，把字符串中的每个空格替换成%20.
 * 例如输入 we are happy.
 * 需转换成 we%20are%20happy.
 *
 * 这里只是用java版本做一个示例，在实际操作中肯定会出现数组越界异常。
 * 从后往前替换：时间复杂度O(n)
 * 从前往后替换：替换时因为长度的变换，涉及到数组中元素的移动，时间复杂度为O(n^2).
 *
 * @author horizonliu
 * @date 2020/10/25 6:55 下午
 */
public class ProblemFour {

    public static void main(String[] args) {
        char[] str = new char[]{'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.'};
        replaceBlank(str);
        System.out.println(str);
    }

    public static void replaceBlank(char[] str) {
        // 输入检查
        if (str == null || str.length <= 0) {
            return;
        }
        int originLength = str.length;
        int newLength = originLength;

        // 计算空格替换成%20后字符串的总长度
        int index = 0;
        while (index < originLength) {
            if (str[index++] == ' ') {
                newLength += 2;
            }
        }
        // 从后往前遍历，遇到空格替换，遇到其他字符复制。
        index = originLength - 1;
        int indexNew = newLength - 1;
        while (index >= 0 || indexNew >= index) {
            if (str[index] == ' ') {
                str[indexNew--] = '0';
                str[indexNew--] = '2';
                str[indexNew--] = '%';
            } else {
                str[indexNew--] = str[index];
            }
            --index;
        }
    }


}
