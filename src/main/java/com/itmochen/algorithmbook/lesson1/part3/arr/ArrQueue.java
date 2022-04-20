package com.itmochen.algorithmbook.lesson1.part3.arr;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * 数组实现队列
 * @author fan
 * @date 2022/4/19 21:05
 * @return
 */
public class ArrQueue<T> implements Iterable<T> {

    private T[] a;

    private Integer size;

    public ArrQueue(Integer capacity) {
        a = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 入队
     * @author fan
     * @date 2022/4/20 14:25
     * @param element 元素
     * @return void
     */
    public void enqueue(T element) {
        // 扩容
        if (size == a.length) resize(size * 2);
        a[size++] = element;
    }

    /**
     * 出队
     * @author fan
     * @date 2022/4/20 14:27
     * @return T
     */
    public T dequeue() {
        if (isEmpty()) return null;
        T t = a[0];
        // 移动元素
        for (int i = 1; i < size; i++)
            a[i - 1] = a[i];
        // 防止对象游离
        a[--size] = null;
        // 扩容
        if (size == a.length / 4) resize(a.length / 2);
        return t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 扩容
     * @author fan
     * @date 2022/4/20 14:25
     * @param capacity 容量
     * @return void
     */
    private void resize(int capacity) {
        System.out.println("stack resize, before capacity:" + a.length + ", after capacity:" + capacity);
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrIterator();
    }

    /**
     * 实现迭代器
     * @author fan
     * @date 2022/4/20 14:35
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
            return a[i--];
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrQueue.class.getSimpleName() + "[", "]")
                .add("a=" + Arrays.toString(a))
                .add("size=" + size)
                .toString();
    }

    public static void main(String[] args) {
        ArrQueue<String> queue = new ArrQueue<>(5);
        String element1 = queue.dequeue();
        System.out.println("element1:" + element1);

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        queue.enqueue("h");
        queue.enqueue("i");
        queue.enqueue("g");
        queue.enqueue("k");
        queue.enqueue("l");
        queue.enqueue("m");
        queue.enqueue("n");
        queue.enqueue("o");
        queue.enqueue("p");
        queue.enqueue("q");
        System.out.println(queue);

        System.out.println("=====================");

        String ele2 = queue.dequeue();
        System.out.println("ele2:" + ele2);
        String ele3 = queue.dequeue();
        System.out.println("ele3:" + ele3);
        String ele4 = queue.dequeue();
        System.out.println("ele4:" + ele4);
        String ele5 = queue.dequeue();
        System.out.println("ele5:" + ele5);
        String ele6 = queue.dequeue();
        System.out.println("ele6:" + ele6);
        String ele7 = queue.dequeue();
        System.out.println("ele7:" + ele7);
        String ele8 = queue.dequeue();
        System.out.println("ele8:" + ele8);
        String ele9 = queue.dequeue();
        System.out.println("ele9:" + ele9);
        String ele10 = queue.dequeue();
        System.out.println("ele10:" + ele10);
        String ele11 = queue.dequeue();
        System.out.println("ele11:" + ele11);
        String ele12 = queue.dequeue();
        System.out.println("ele12:" + ele12);
        String ele13 = queue.dequeue();
        System.out.println("ele13:" + ele13);
        String ele14 = queue.dequeue();
        System.out.println("ele14:" + ele14);
        String ele15 = queue.dequeue();
        System.out.println("ele15:" + ele15);
        System.out.println(queue);
    }

}
