package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        System.out.println(Arrays.toString(a));

//        int[] arr = new int[800000];
//        for (int i = 0; i < 800000; i++) {
//            arr[i] = (int) (Math.random() * 1000000);
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间：" + data1Str);
//        mergeSort(arr, 0, arr.length - 1);
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间：" + data2Str);
        //System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left < right) {//当子序列中只有一个元素时结束递归
            int mid = (left + right) / 2;//划分子序列
            mergeSort(a, left, mid);//对左侧子序列进行递归排序
            mergeSort(a, mid + 1, right);//对右侧子序列进行递归排序
            merge(a, left, mid, right);//合并
        }
    }

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[a.length];//辅助数组
        int i = left, j = mid + 1, t = 0;//p1、p2是检测指针，t是存放指针
        while (i <= mid && j <= right) {
            if (a[i] <= a[j])
                temp[t++] = a[i++];
            else
                temp[t++] = a[j++];
        }
        while (i <= mid) {
            temp[t++] = a[i++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        }
        while (j <= right) {
            temp[t++] = a[j++];//同上
        }
        //复制回原素组 注意，并不是每次都拷贝所有
        t = 0;
        for (int k = left; k <=right; k++){
            a[k]=temp[t++];
        }
    }


}
