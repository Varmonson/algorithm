package com.itmochen.leetcode.num;

public class NumSolution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int twoSum(int[] A) {
        // write your code here
        for(int i = 0; i < A.length; i++){
            boolean flag = false;
            for (int j = 0; j < A.length; j++) {
                if (A[i] == A[j] && i != j) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new NumSolution().twoSum(new int[]{1,1,2,2,3,4,4}));
    }

}
