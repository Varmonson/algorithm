package com.itmochen.algorithmbook.lesson1.part3.arr;


import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * 数组实现栈
 * @author fan
 * @date 2022/4/19 10:58
 * @return
 */
public class ArrStack<T> implements Iterable<T> {

    private T[] stack;

    private Integer size;

    public ArrStack(Integer capacity) {
        stack = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 入栈
     * @author fan
     * @date 2022/4/19 11:04
     * @param ele
     * @return void
     */
    public void push(T ele) {
        if (stack.length == size) resize(size * 2);
        stack[size++] = ele;
    }

    /**
     * 出栈
     * @author fan
     * @date 2022/4/19 11:04
     * @return T
     */
    public T pop() {
        // 栈为空
        if (isEmpty()) return null;
        T t = stack[--size];
        // 防止对象游离
        stack[size] = null;
        if (size > 0 && stack.length / 4 == size) resize(stack.length / 2);
        return t;
    }

    /**
     * 扩容
     * @author fan
     * @date 2022/4/19 11:06
     * @return void
     */
    private void resize(Integer newSize) {
        System.out.println("stack resize, before capacity:" + stack.length + ", after capacity:" + newSize);
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    /**
     * 判断是否为空
     * @author fan
     * @date 2022/4/19 20:25
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
    public String toString() {
        return new StringJoiner(", ", ArrStack.class.getSimpleName() + "[", "]")
                .add("stack=" + Arrays.toString(stack))
                .add("size=" + size)
                .toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrIterator();
    }

    private class ArrIterator implements Iterator<T> {

        private Integer i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return stack[--i];
        }
    }

    public static void main(String[] args) {
        ArrStack<Integer> stack = new ArrStack<>(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(8);
        stack.push(10);
        System.out.println(stack);
        System.out.println("=====================================");

        Iterator<Integer> arrIterator = stack.iterator();
        while (arrIterator.hasNext()) {
            Integer item = arrIterator.next();
            System.out.print(item + " ");
        }
        System.out.println("==========================");

        Integer ele1 = stack.pop();
        System.out.println("ele1:" + ele1);
        Integer ele2 = stack.pop();
        System.out.println("ele2:" + ele2);
        Integer ele3 = stack.pop();
        System.out.println("ele3:" + ele3);
        Integer ele4 = stack.pop();
        System.out.println("ele4:" + ele4);
        System.out.println(stack);
        Integer ele5 = stack.pop();
        System.out.println("ele5:" + ele5);
        Integer ele6 = stack.pop();
        System.out.println("ele6:" + ele6);
        Integer ele7 = stack.pop();
        System.out.println("ele7:" + ele7);
        System.out.println(stack);

    }
}
