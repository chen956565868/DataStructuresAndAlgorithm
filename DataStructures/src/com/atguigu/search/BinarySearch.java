package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8, 10, 89, 1000,1234};
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    //二分查找
    public static int binarySearch(int[] arr,int left,int right,int fandVal){
        //当left > right时结束递归
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (fandVal > midVal){//向右递归
            return binarySearch(arr,mid + 1,right,fandVal);
        }else if (fandVal < midVal){//向左递归
            return binarySearch(arr,left,mid -1,fandVal);
        }else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int fandVal){
        //当left > right时结束递归
        if (left > right){
            return null;
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (fandVal > midVal){//向右递归
            return binarySearch2(arr,mid + 1,right,fandVal);
        }else if (fandVal < midVal){//向左递归
            return binarySearch2(arr,left,mid -1,fandVal);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp<0 || arr[temp]!=fandVal){
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!=fandVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
