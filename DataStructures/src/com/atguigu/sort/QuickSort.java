package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left+right)/2];
        int temp = 0;//交换的临时变量
        //while 把比pivot小的放左边 比pivot大的放右边
        while (l < r){
            while (arr[l]<pivot){//在左边找到比pivot大的才退出
                l++;
            }
            while (arr[r]>pivot){//在右边找到比pivot小的才退出
                r--;
            }
            //如果l>=r 说明pivot两边的值已全是大于/小于的值
            if (l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换后 发现arr[l]==pivot，让r前移
            if (arr[l]==pivot){
                r--;
            }
            //如果交换后 发现arr[r]==pivot，让l后移
            if (arr[r]==pivot){
                l++;
            }
        }
        //如果l==r 会出现栈溢出
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){

        }
    }

    /*
     * 首先需要一个数组存放所有的数据
     * 定一个开始位置和一个结束为止
     * 选择一个数作为准基数
     */
    public static void quickSort2(int a[],int min,int max) {
        int key=a[min];//准基数
        int start=min; //开始位置
        int end =max;//结束位置
        while(end>start) {  //循环条件是否数值交叉
            //从后开始往前查找
            while(end>start&&a[end]>=key) {
                //如果找到的值大于基数值，那么继续往下找，end--
                end--;
            }
            //如果找到的值小于基数值，那么进行值交换
            if(a[end]<key) {
                int i=a[end];
                a[end]=a[start];
                a[start]=i;
            }
            //从前往后找
            while(end>start&&a[start]<=key) {
                //如果找到的值小于基数值，那么继续往下找，start++
                start++;
            }
            //如果找到的值大于基数值，那么进行值交换
            if(a[start]>key) {
                int i=a[start];
                a[start]=a[end];
                a[end]=i;
            }
        }
        //这部分的数据都是小于准基数，通过递归在进行一趟快排
        if(start>min) {
            quickSort2(a, min, start-1);  //开始位置为第一位，结束位置为关键索引-1
        }
        if(end<max) {
            quickSort2(a, end+1, max);  //开始位置为关键索引+1，结束位置最后一位
        }


    }



}