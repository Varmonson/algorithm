package com.itmochen.algorithmbook.lesson1.part3.arr;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 数组实现栈
 * @author fan
 * @date 2022/4/19 10:58
 * @return
 */
public class ArrStack<T> {

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
        size--;
        T t = stack[size];
        // 防止对象游离
        stack[size] = null;
        if (stack.length / 4 > size) resize(stack.length / 2);
        return t;
    }

    /**
     * 扩容
     * @author fan
     * @date 2022/4/19 11:06
     * @return void
     */
    public void resize(Integer newSize) {
        System.out.println("stack resize, before capacity:" + stack.length + ", after capacity:" + newSize);
        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArrStack.class.getSimpleName() + "[", "]")
                .add("stack=" + Arrays.toString(stack))
                .add("size=" + size)
                .toString();
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

        Integer ele1 = stack.pop();
        System.out.println(ele1);
        Integer ele2 = stack.pop();
        System.out.println(ele2);
        Integer ele3 = stack.pop();
        System.out.println(ele3);
        Integer ele4 = stack.pop();
        System.out.println(ele4);
        System.out.println(stack);
    }
}
