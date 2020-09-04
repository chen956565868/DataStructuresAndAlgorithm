package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        int[] arr = {5,4,3,3,2,1};
//        System.out.println("原始数组");
//        System.out.println(Arrays.toString(arr));
//        insertSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*1000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间："+data1Str);
        //测试冒泡排序速度
        insertSort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序前时间："+data2Str);
    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertValue = arr[i];
            int insertIndex = i-1;//比较值的索引
            if (arr[i]>=arr[i-1]){
                continue;
            }
            //给insertValue 找到插入的位置
            while (insertIndex>=0 && insertValue < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];//后移
                insertIndex--;
            }
            //此时 插入的位置找到 insertIndex+1
            arr[insertIndex+1] = insertValue;
//            System.out.println("第"+i+"轮");
//            System.out.println(Arrays.toString(arr));
        }
//        System.out.println("排序结束");
    }
}
