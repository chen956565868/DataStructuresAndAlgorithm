package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    queue.showQueue();;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数据是："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("队列头数据是："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("已退出");
        }
    }
}

class CircleArray{
    private int maxSize;//数组最大容量
    private int front;//队列头：指向队列的第一个元素
    private int rear;//队列尾：指向队列的最后一个元素的后一个位置
    private int[] arr;//模拟队列
    //构造函数
    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断是否满
        if (isFull()){
            System.out.println("队列满，不能加入");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移 考虑取模
        rear = (rear+1)%maxSize;
    }
    //取数据
    public int getQueue(){
        //判断是为空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //1.先把front对应的值保存到一个临时变量
        int value = arr[front];
        //2.将front后移
        front = (front+1)%maxSize;
        return value;
    }
    //显示队列的所有数据
    public void showQueue(){
        //判断是为空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //从front开始遍历 遍历有效数据
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //取出当前队列有效数据
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示头数据
    public int headQueue(){
        //判断是为空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }

}
