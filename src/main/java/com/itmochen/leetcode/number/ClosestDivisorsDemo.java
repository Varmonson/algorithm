package com.itmochen.leetcode.number;

/**
 *
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *
 *      1.两数乘积等于  num + 1 或 num + 2
 *      2.以绝对差进行度量，两数大小最接近
 *
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 *
 * 输入：num = 123
 * 输出：[5,25]
 *
 * 输入：num = 999
 * 输出：[40,25]
 *
 *
 * @Author: fan
 * @Date: 2022/1/12 14:05
 * @Version: 1.0
 **/
public class ClosestDivisorsDemo {

    public int[] closestDivisors(int num) {
        int[] nums = new int[2];
        int diff = num + 2;

        int i1, j1, i2, j2;

        // 遍历 0 < num/2，取出num+1最近两个因子
       for (i1 = 1; i1 <= num + 1; i1++) {
            for (j1 = 1; j1 <= num + 1; j1++) {
                if (i1 * j1 == num + 1 && Math.abs(j1 - i1) < diff) {
                    nums[0] = i1;
                    nums[1] = j1;
                    diff = Math.abs(j1 - i1);
                }
            }
        }
        for (i2 = 1; i2 <= num + 2; i2++) {
            for (j2 = 1; j2 <= num + 2; j2++) {
                if (i2 * j2 == num + 2 && Math.abs(j2 - i2) < diff) {
                    nums[0] = i2;
                    nums[1] = j2;
                    diff = Math.abs(j2 - i2);
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        for (int i : new ClosestDivisorsDemo().closestDivisors(170967091)) {
            System.out.print(i + " ");
        }

    }

}
