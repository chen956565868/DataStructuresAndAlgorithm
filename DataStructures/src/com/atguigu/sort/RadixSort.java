package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);

        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 1000000);
        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间：" + data1Str);
//        radixSort(arr);
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间：" + data2Str);
        //System.out.println(Arrays.toString(arr));
        long data1Str = System.currentTimeMillis();
        radixSort(arr);
        long data2Str = System.currentTimeMillis();
        System.out.println("排序前时间："+(data2Str-data1Str));

    }


    //基数排序
    public static void radixSort(int[] arr){
        //得到数组中的最大数
        int max = arr[0];//假设第一个数为最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //得到数组中d的最大数的位数
        int maxLength = (max + "").length();
        //定义一个二维数组 表示10个桶 每个桶就是一个一位数组
        int[][] bucket = new int[10][arr.length];
        //定义一个一位数组 记录每个桶每次放的个数
        //一位数组的下标=位数数字 值=个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的位数
                int digitOfElement = arr[j] / n %10;
                //入桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //取数据 放入原数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据 放入原数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶(k)桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取元素 放原数组
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //将bucketElementCounts[k]=0
                bucketElementCounts[k] = 0;
            }
//            System.out.println("第"+(i+1)+"轮 对个位数排序");
//            System.out.println(Arrays.toString(arr));
        }



//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的个位数
//            int digitOfElement = arr[j]%10;
//            //入桶
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //取数据 放入原数组
//        int index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据 放入原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶(k)桶
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取元素 放原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            //将bucketElementCounts[k]=0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第1轮 对个位数排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第2轮   十位数
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的十位数
//            int digitOfElement = arr[j]/10 %10;
//            //入桶
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //取数据 放入原数组
//        index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据 放入原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶(k)桶
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取元素 放原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            //将bucketElementCounts[k]=0
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第2轮 对十位数排序");
//        System.out.println(Arrays.toString(arr));
//
//        //第2轮   百位数
//        for (int j = 0; j < arr.length; j++) {
//            //取出每个元素的百位数
//            int digitOfElement = arr[j]/100 ;
//            //入桶
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //取数据 放入原数组
//        index = 0;
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据 放入原数组
//            if (bucketElementCounts[k] != 0){
//                //循环该桶(k)桶
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取元素 放原数组
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//        }
//        System.out.println("第3轮 对百位数排序");
//        System.out.println(Arrays.toString(arr));


    }
}
