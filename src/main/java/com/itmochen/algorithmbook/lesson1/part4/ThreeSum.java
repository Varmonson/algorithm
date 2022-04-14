package com.itmochen.algorithmbook.lesson1.part4;

import com.itmochen.algorithmbook.sdk.In;
import com.itmochen.algorithmbook.sdk.StdOut;

/**
 * 统计所有和为0的三整数元组的数量（假设整数不外溢）
 */
public class ThreeSum {

    /**
     * 统计和为0的元组数量
     * @param a
     * @return
     */
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
