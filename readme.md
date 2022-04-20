#数据结构和算法

参考算法（第四版）与leetcode算法题

-------------------------------
##1.基础数据结构：背包(Bag)、队列(Queue)、栈(Stack)

###1.1API
    - 背包
        - void add();
        - boolean isEmpty();
    - 队列
        - void enqueue(T item);
        - T dequeue();
        - boolean isEmpty();
    - 栈
        - void push();
        - T pop();
        - boolean isEmpty();

###1.2两种方式实现

    - 数组：
        队列和栈需防止对象游离（出栈和出队索引置为null）
    - 链表：
        - 背包：头插法
        - 队列：先进先出、尾插法
        - 栈：先进后出、头插法