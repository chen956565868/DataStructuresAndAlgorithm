package com.atguigu.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,-1,100,0,-20};
        heapSort(arr);

//        int[] arr = new int[80000000];
//        for (int i = 0; i < 80000000; i++) {
//            arr[i] = (int) (Math.random() * 1000000);
//        }
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        String data1Str = simpleDateFormat.format(date1);
//        System.out.println("排序前时间：" + data1Str);
//        heapSort(arr);
//        Date date2 = new Date();
//        String data2Str = simpleDateFormat.format(date2);
//        System.out.println("排序后时间：" + data2Str);
//        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int[] arr){
        int temp = 0;
//        adjustHeap(arr,1,arr.length);
//        System.out.println(Arrays.toString(arr));//49856
//        adjustHeap(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));//96854

        //将数组调整成大顶堆
        for (int i = arr.length/2 - 1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
        for (int j = arr.length -1; j >0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //此时只有堆顶和末尾不是大顶堆
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }



    /** 将i为父结点的子树 调整为大顶堆
     * @param arr 待调整的数组
     * @param i   非叶子结点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr,int i,int length){
        //保存当前元素的值
        int temp = arr[i];
        //k = i*2+1, k 是 i 结点的左子结点
        for (int k = i*2+1; k < length; k = k*2+1) {
            if (k+1 < length && arr[k] < arr[k+1]){//左子结点<右子结点
                k++;//指向右子结点
            }
            if (arr[k] > temp){//如果子结点大于父结点
                arr[i] = arr[k];////把较大的值赋给当前结点
                i = k;//i 指向 k,继续循环比较,便于下方交换位置
            }else {
                break;
            }
        }//此时已经将i为父结点的子树 调整为大顶堆
        arr[i] = temp;//将temp值放到调整后的位置
    }
}
