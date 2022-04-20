package com.itmochen.algorithmbook.lesson1.part3.linked;

import java.util.Iterator;

/**
 * 链表实现背包
 * @Author: fan
 * @Date: 2022/4/13 9:34
 * @Version: 1.0
 **/
public class LinkedBag<T> implements Iterable<T>{

    // 第一个元素
    private Node first;

    /**
     * 头部插入元素
     * @author fan
     * @date 2022/4/20 22:27
     * @param item
     * @return void
     */
    public void add(T item) {
        Node oldFile = first;
        first = new Node();
        first.item= item;
        first.next = oldFile;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    /**
     * 节点内部类
     * @author fan
     * @date 2022/4/20 22:22
     */
    private class Node {
        // 元素
        private T item;
        // 下个节点
        private Node next;
    }

    /**
     * 实现迭代器
     * @author fan
     * @date 2022/4/20 22:28
     */
    private class LinkedIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        LinkedBag<Integer> bag = new LinkedBag<>();
        bag.add(10);
        bag.add(20);
        bag.add(31);
        bag.add(12);
        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}
