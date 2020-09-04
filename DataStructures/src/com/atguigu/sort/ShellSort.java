package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {5,7,8,3,1,2,4,6};
//        shellSort2(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*1000000);
        }
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String data1Str = simpleDateFormat.format(date1);
        long data1Str = System.currentTimeMillis();
        //System.out.println("排序前时间："+data1Str);
        //测试冒泡排序速度
        shellSort2(arr);
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
        long data2Str = System.currentTimeMillis();
        System.out.println("排序前时间："+(data2Str-data1Str));
        //System.out.println(Arrays.toString(arr));
    }

    //Shell排序
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j -= gap) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
//            System.out.print("第"+(++count)+"轮");
//            System.out.println(Arrays.toString(arr));
        }


//        //第二轮
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i-2; j >=0 ; j -= 2) {
//                if (arr[j] > arr[j+2]){
//                    temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println("第2轮");
//        System.out.println(Arrays.toString(arr));
    }

    //Shell排序
    public static void shellSort2(int[] arr){
        //增量gap 逐步缩小gap
        for (int gap = arr.length/2; gap >0 ; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;//后面的数的索引
                int temp = arr[j];//后面的数的值存入temp
                while (j - gap >= 0 && temp < arr[j - gap]){
                    //移动
                    arr[j] = arr[j-gap];//把前面的数(大数)移动到后面
                    j -= gap;//减小后面数的索引
                }
                //当退出 while 后，就给 temp 找到插入的位置
                arr[j] = temp;//移动小数
            }
        }
    }
}
