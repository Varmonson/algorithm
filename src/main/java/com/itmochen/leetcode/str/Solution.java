package com.itmochen.leetcode.str;

public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        char[] nstr = new char[str.length];
        int idx = offset % str.length;
        int lidx = idx;
        for(int i = str.length - 1; i >= str.length - idx; i--) {
            lidx--;
            nstr[lidx] = str[i];
        } 

        int ridx = idx;
        for (int i = 0; i < str.length - ridx; i++) {
            nstr[idx] = str[i];
            idx++; 
        }

        System.out.println("\"" + new String(nstr));
    }

    public static void main(String[] args) {
        new Solution().rotateString("abcdefg".toCharArray(), 10);
    }
}