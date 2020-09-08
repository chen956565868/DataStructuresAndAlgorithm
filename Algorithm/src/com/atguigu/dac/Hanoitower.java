package com.atguigu.dac;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');
    }

    //汉诺塔移动方案 分治算法
    public static void hanoiTower(int num, char a,char b, char c) {
        if (num == 1){//只有一个盘
            System.out.println("第1个盘从"+ a + "->" +c);
        }else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的盘 2. 上面的盘
            //1.先把上面的所有盘 A->B
            hanoiTower(num - 1,a,c,b);//中间借助c移动
            //2.把最下边的盘 A->C
            System.out.println("第"+ num +"个盘从"+ a + "->" +c);
            //3.把 B 塔的所有盘 从 B->C
            hanoiTower(num - 1,b,a,c);//中间借助a移动
        }
    }
}
