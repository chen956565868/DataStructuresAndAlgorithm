package com.atguigu.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder();//1245367
//        arrBinaryTree.infixOrder();//4251637
        arrBinaryTree.postOrder();//4526731
    }
}

class ArrBinaryTree{
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    //顺序存储二叉树的前序遍历
    public void preOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("数组为空");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if (2*index+1 < arr.length){
            preOrder(2*index+1);
        }
        //向右递归
        if (2*index+2 < arr.length){
            preOrder(2*index+2);
        }
    }

    public void infixOrder(){
        this.infixOrder(0);
    }

    //顺序存储二叉树的中序遍历
    public void infixOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("数组为空");
            return;
        }
        //向左递归
        if (2*index+1 < arr.length){
            infixOrder(2*index+1);
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向右递归
        if (2*index+2 < arr.length){
            infixOrder(2*index+2);
        }
    }

    public void postOrder(){
        this.postOrder(0);
    }

    //顺序存储二叉树的中序遍历
    public void postOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("数组为空");
            return;
        }
        //向左递归
        if (2*index+1 < arr.length){
            postOrder(2*index+1);
        }
        //向右递归
        if (2*index+2 < arr.length){
            postOrder(2*index+2);
        }
        //输出当前元素
        System.out.println(arr[index]);

    }


}
