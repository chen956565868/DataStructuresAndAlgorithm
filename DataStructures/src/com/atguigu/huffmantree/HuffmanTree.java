package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    //创建赫夫曼树
    public static Node createHuffmanTree(int[] arr){
        //遍历arr数组
        //将arr的每个元素 构建成一个Node
        //将Node放入ArrayList
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1){
            //排序 从小到大
            Collections.sort(nodes);
//            System.out.println("未处理");
//            System.out.println(nodes);
            //取出根节点权值最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //构建新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //加入parent
            nodes.add(parent);
//            System.out.println("第一次处理后");
//            System.out.println(nodes);
        }
        //返回赫夫曼树的root
        return nodes.get(0);
    }

    //前序遍历
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }
}

//节点类
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
