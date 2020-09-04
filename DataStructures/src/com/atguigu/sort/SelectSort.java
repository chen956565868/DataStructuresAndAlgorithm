package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
//        System.out.println("排序前");
//        int[] arr = {101,34,119,1};
//        int[] arr = {1,2,3,4,5,6,7,8};
//        System.out.println(Arrays.toString(arr));
//        selectSort(arr);


        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random()*1000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间："+data1Str);
        //测试冒泡排序速度
        selectSort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序前时间："+data2Str);
    }

    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;//假定最小值的索引
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]){//说明min不是最小值
                    min = arr[j];//重置min
                    minIndex = j;
                }
            }
            //此时min是最小值 minIndex是最小值的索引
            //交换
            if (min==arr[i]){
                continue;
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
//            System.out.println("第"+i+"轮");
//            System.out.println(Arrays.toString(arr));
        }
        System.out.println("排序结束");




    }
}
