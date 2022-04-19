package com.itmochen.algorithmbook.lesson1.part3.arr;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组实现Bag
 *
 * @Author: fan
 * @Date: 2022/4/11 16:40
 * @Version: 1.0
 **/
public class ArrBag<T> implements Iterable<T>{

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

    /**
     * 判断是否为空
     * @author fan
     * @date 2022/4/19 20:24
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取大小
     * @author fan
     * @date 2022/4/19 20:34
     * @return java.lang.Integer
     */
    public Integer size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrIterator();
    }

    /**
     *  迭代器
     * @author fan
     * @date 2022/4/19 21:15
     * @return
     */
    private class ArrIterator implements Iterator<T> {

        private Integer i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return items[--i];
        }
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

        System.out.println("====================");

        Iterator<String> iterator = bag.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
