package com.atguigu.thread;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("Mythread");
        myThread.setPriority(1);
        myThread.start();
        Thread.currentThread().setPriority(10);
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(i+Thread.currentThread().getName() +"  " +Thread.currentThread().getPriority());
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 != 0){
             System.out.println(i+Thread.currentThread().getName()+"  " +Thread.currentThread().getPriority());
            }
        }
    }
}
