package com.atguigu.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();//获取字节数组
//        System.out.println(contentBytes.length);//40
        // 把字符和次数的关系 存入Map 封装为Node 存入nodes
        List<Node> nodes = getNode(contentBytes);
        //[Node{data=32, weight=9}, Node{data=97, weight=5}]
        System.out.println(nodes);

        Node root = createHuffmanTree(nodes);
        root.preOrder();

//        getCodes(root,"",stringBuilder);
        Map<Byte, String> huffmanCodes = getCodes(root);
        System.out.println(huffmanCodes);

    }


    //赫夫曼编码表存入Map<Byte,String>
    static Map<Byte,String> huffmanCodes = new HashMap<Byte, String>();
    //定义StringBuilder 存储叶子结点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        //处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }

    /** 生成赫夫曼树对应的赫夫曼编码表
     * 将node结点的所有叶子结点的赫夫曼编码存入Map中
     * @param node  传入的结点
     * @param code 路径：左子结点0     右子结点1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将Code加入到stringBuilder2
        stringBuilder2.append(code);
        if (node != null){
            if (node.data == null){//非叶子结点
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else {//叶子结点
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }



    //通过List创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 把字符和次数的关系 存入Map 封装为Node 存入ArrayList
    //[Node{data=32, weight=9}, Node{data=97, weight=5}]
    private static List<Node> getNode(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null){//Map中没有字符数据
                counts.put(b,1);//存入Map
            }else {//Map中有字符数据
                counts.put(b,count+1);
            }
        }//把每个键值对 封装为Node 存入nodes
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}

class Node implements Comparable<Node>{
    Byte data;//存放数据本身
    int weight;//权值
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
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
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
