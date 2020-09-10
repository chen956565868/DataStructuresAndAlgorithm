package com.atguigu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//1.创建Callable实现类
class NumThread implements Callable{
    //2.将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i %2==0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        //3.创建Callable实现类对象
        NumThread numThread = new NumThread();
        //4.将Callable实现类对象传递到FutureTask构造器中
        FutureTask futureTask = new FutureTask(numThread);
        //5.创建Thread对象 传递futureTask
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("sum="+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
