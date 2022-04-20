package com.itmochen.algorithmbook.lesson1.part3.linked;

import java.util.Iterator;

/**
 * 链表实现队列-尾插法
 * @author fan
 * @date 2022/4/20 22:36
 */
public class LinkedQueue<T> implements Iterable<T>{

    // 头指针
    private Node first;
    // 队列长度
    private Integer size = 0;
    // 尾指针
    private Node last;

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     * @author fan
     * @date 2022/4/20 22:43
     * @param item
     * @return void
     */
    public void enqueue(T item) {
        // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    /**
     * 出队
     * @author fan
     * @date 2022/4/20 23:01
     * @return T
     */
    public T dequeue() {
        // 从表头删除元素
        if (first == null) return null;
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) first = last = null;
        return item;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    /**
     * 实现迭代器
     * @author fan
     * @date 2022/4/20 22:42
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

    /**
     * 链表节点
     * @author fan
     * @date 2022/4/20 22:39
     * @return
     */
    private class Node {
        // 元素
        T item;
        // 下个节点
        Node next;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> lqueue = new LinkedQueue<>();
        Integer item1 = lqueue.dequeue();
        System.out.println("item1:" + item1);

        lqueue.enqueue(12);
        lqueue.enqueue(13);
        lqueue.enqueue(14);
        lqueue.enqueue(21);

        Iterator<Integer> iterator = lqueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Integer item2 = lqueue.dequeue();
        System.out.println("item2:" + item2);
        Integer item3 = lqueue.dequeue();
        System.out.println("item3:" + item3);
        Integer item4 = lqueue.dequeue();
        System.out.println("item4:" + item4);
        Integer item5 = lqueue.dequeue();
        System.out.println("item5:" + item5);

        Iterator<Integer> iterator2 = lqueue.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }

    }
}
