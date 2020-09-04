package com.atguigu.recursion;

public class Queue8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    //开始放置
    private void check(int n){
        if (n==max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //把当前皇后n 放到第一列
            array[n] = i;
            //判断是否冲突
            if (judge(n)){//不冲突
                //接着放n+1 开始递归
                check(n+1);
            }
        }
    }

    //判断是否冲突    n个皇后
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i]==array[n] 判断是否同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]) 判断是否同一斜线
            if (array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;

    }


    //打印皇后位置
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}


