package com.atguigu.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据,
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部，分析出 front 是指向队列头的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        rear = -1;
    }
    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;// 让 rear 后移
        arr[rear] = n;
    }
    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        // front 后移
        return arr[front];
    }
    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}

