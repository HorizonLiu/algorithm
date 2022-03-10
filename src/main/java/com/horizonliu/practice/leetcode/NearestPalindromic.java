package com.horizonliu.practice.leetcode;

import lombok.Lombok;

/**
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/
 *
 * @author horizonliu
 * @date 2022/2/15 4:09 下午
 */
public class NearestPalindromic {

    public String nearestPalindromic(String n) {
        if (n.equals("10")) {
            return "9";
        }
        long number = Long.parseLong(n);
        // 前半段复制后不等于原始字符串
        String mirror = mirror(n);
        long diff1 = Math.abs(Long.parseLong(mirror) - number);

        int len = n.length();
        boolean odd = len % 2 == 1;
        long pre;
        String preAdd1;
        String preSub1;
        // 奇数长
        if (odd) {
            pre = Long.parseLong(n.substring(0, len / 2 + 1));
            preAdd1 = String.valueOf(pre + 1)
                    + new StringBuilder(String.valueOf(pre + 1).substring(0, len / 2)).reverse();
            preSub1 = String.valueOf(pre - 1)
                    + new StringBuilder(String.valueOf(pre - 1).substring(0, len / 2)).reverse();
            // 偶数长
        } else {
            pre = Long.parseLong(n.substring(0, len / 2));
            // +1后拉长了一位时
            if (String.valueOf(pre + 1).length() > String.valueOf(pre).length()) {
                preAdd1 = String.valueOf(pre + 1) + new StringBuilder(String.valueOf(pre + 1).substring(0, len / 2))
                        .reverse();
            } else {
                preAdd1 = String.valueOf(pre + 1) + new StringBuilder(String.valueOf(pre + 1)).reverse();
            }
            // -1后减少了一位时
            if (String.valueOf(pre - 1).length() < String.valueOf(pre).length()) {
                preSub1 = String.valueOf(pre - 1) + "9" + new StringBuilder(String.valueOf(pre - 1)).reverse();
            } else {
                preSub1 = String.valueOf(pre - 1) + new StringBuilder(String.valueOf(pre - 1)).reverse();
            }
        }
        long diff2 = Math.abs(Long.parseLong(preAdd1) - number);
        long diff3 = Math.abs(Long.parseLong(preSub1) - number);
        // 若镜像字符串和本身相等，直接标胶diff2和diff3
        if (mirror.equals(n)) {
            return diff2 < diff3 ? preAdd1 : preSub1;
        }
        // 镜像字符串和本身不相等，比较diff1.2.3
        // diff1最小
        if (diff1 < diff2 && diff1 < diff3) {
            return mirror;
        }
        // diff1和diff2最小
        if (diff1 == diff2 && diff1 < diff3) {
            return Long.parseLong(mirror) > Long.parseLong(preAdd1) ? preAdd1 : mirror;
        }
        // diff1和diff3最小
        if (diff1 == diff3 && diff1 < diff2) {
            return Long.parseLong(mirror) > Long.parseLong(preSub1) ? preSub1 : mirror;
        }
        return diff2 < diff3 ? preAdd1 : preSub1;
    }

    /**
     * 求字符串s的镜像
     *
     * @param s 字符串
     * @return
     */
    public String mirror(String s) {
        int len = s.length();
        String pre = s.substring(0, len / 2);
        String preReverse = new StringBuilder(pre).reverse().toString();
        return pre + (len % 2 == 0 ? preReverse : s.charAt(len / 2) + preReverse);
    }

    public static void main(String[] args) {
        NearestPalindromic palindromic = new NearestPalindromic();
        System.out.println(palindromic.nearestPalindromic("1805170081"));
    }

}
