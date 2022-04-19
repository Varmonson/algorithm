package com.itmochen.algorithmbook.lesson1.part3.arr;

import java.util.Arrays;

/**
 * 数组实现Bag
 *
 * @Author: fan
 * @Date: 2022/4/11 16:40
 * @Version: 1.0
 **/
public class ArrBag<T> {

    /**
     * 泛型集合
     */
    private T[] items;

    /**
     * 集合长度
     */
    private Integer size = 0;

    public ArrBag(int capacity) {
        items = (T[])new Object[capacity];
    }

    /**
     * 插入元素
     * @param element 新元素
     */
    public void add(T element) {
        // 扩容
        if (items.length == size) resize(size * 2);
        // 插入新元素
        items[size++] = element;
    }

    /**
     * 扩容
     */
    private void resize(int newSize) {
        // 创建新数组
        T[] temp = (T[]) new Object[newSize];
        // 拷贝元素
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public String toString() {
        return "ArrBag{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }


    public static void main(String[] args) {
        ArrBag<String> bag = new ArrBag<>(2);
        bag.add("hey");
        System.out.println(bag);
        bag.add("bag");
        System.out.println(bag);
        bag.add("!");
        System.out.println(bag);

    }

}
