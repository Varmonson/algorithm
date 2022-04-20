package com.itmochen.algorithmbook.lesson1.part3.linked;

import java.util.Iterator;

/**
 * 链表实现队列-头插法
 * @author fan
 * @date 2022/4/20 23:10
 */
public class LinkedStack<T> implements Iterable<T> {

    // 头指针
    private Node first;
    // 栈容量
    private Integer size = 0;

    /**
     * 进栈
     * @author fan
     * @date 2022/4/20 23:16
     * @param item
     * @return void
     */
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * 出栈
     * @author fan
     * @date 2022/4/20 23:21
     * @return T
     */
    public T pop() {
        if (first == null) return null;
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) first = null;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    /**
     * 节点
     * @author fan
     * @date 2022/4/20 23:12
     */
    private class Node {
        T item;
        Node next;
    }

    /**
     * 实现迭代器
     * @author fan
     * @date 2022/4/20 23:25
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
        LinkedStack<Integer> lstack = new LinkedStack<>();

        Integer item1 = lstack.pop();
        System.out.println("item1:" + item1);

        lstack.push(12);
        lstack.push(20);
        lstack.push(13);
        lstack.push(43);

        Iterator<Integer> iterator = lstack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Integer item2 = lstack.pop();
        System.out.println("item2:" + item2);
        Integer item3 = lstack.pop();
        System.out.println("item3:" + item3);
        Integer item4 = lstack.pop();
        System.out.println("item4:" + item4);
        Integer item5 = lstack.pop();
        System.out.println("item5:" + item5);


    }
}
