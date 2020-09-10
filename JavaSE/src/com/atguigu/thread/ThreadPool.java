package com.atguigu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName() +": "+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName() +": "+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定县城操作 需要提供Runnable/Callable的实现类
        service.execute(new NumberThread());//适用与Runnable
        service.execute(new NumberThread1());
//        service.submit();//适用与Callable
        //3.关闭连接池
        service.shutdown();
    }
}
