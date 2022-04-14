package com.itmochen.leetcode.num;

public class DataTypeReference {

    private Integer count = 10;

    public Integer getCount() {
        return count;
    }

    private void increment() {
        count++;
    }

    public int increment(int num) {
        return ++num;
    }

    public Integer increment(Integer num) {
        return ++num;
    }

    public static void main(String[] args) {
        int n = 10;
        Integer n1 = 10;
        DataTypeReference dataTypeReference = new DataTypeReference();
        int res = dataTypeReference.increment(n);
        System.out.println(res);
        System.out.println(n);
        System.out.println("---------------------------");
        Integer res1 = dataTypeReference.increment(n1);
        System.out.println(res1);
        System.out.println(n1);
        System.out.println("---------------------------");

        dataTypeReference.increment();
        System.out.println(dataTypeReference.getCount());

        DataTypeReference dataTypeReference2 = dataTypeReference;
        dataTypeReference2.increment();
        System.out.println(dataTypeReference2.getCount());
        System.out.println(dataTypeReference.getCount());
        System.out.println("dataTypeReference2:" + dataTypeReference2);
        System.out.println("dataTypeReference:" + dataTypeReference);
    }

}
