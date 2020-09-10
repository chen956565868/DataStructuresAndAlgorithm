package com.atguigu.thread;

class Mthread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i+"  "+Thread.currentThread().getName());
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        new Thread(new Mthread(),"t1").start();
    }
}
