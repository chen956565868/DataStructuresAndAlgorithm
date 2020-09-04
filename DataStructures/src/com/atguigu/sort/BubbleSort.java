package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, -2};
//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*1000000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间："+data1Str);
        //测试冒泡排序速度
        bubbleSort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序前时间："+data2Str);
    }

    //将冒泡排序算法封装成一个方法
    public static void bubbleSort(int[] arr){
        int item = 0;//临时变量 用作交换
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                //如果前面的数比后面的数大 则交换
                if (arr[j] > arr[j+1]){
                    item = arr[j] ;
                    arr[j] = arr[j+1];
                    arr[j+1] = item;
                    flag = true;
                }
            }
            //System.out.println("第"+(i+1)+"趟排序："+Arrays.toString(arr));
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }











}
