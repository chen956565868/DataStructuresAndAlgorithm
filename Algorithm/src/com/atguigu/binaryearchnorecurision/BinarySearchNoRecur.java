package com.atguigu.binaryearchnorecurision;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = BinarySearch(arr, 8);
        System.out.println(index);
    }

    //二分查找 非递归
    public static int BinarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid - 1;//向左查找
            }else {
                left = mid + 1;//向右查找
            }
        }
        return -1;
    }
}
