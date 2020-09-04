package com.atguigu.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        System.out.println("前序遍历");//12354
        binaryTree.preOrder();
        System.out.println("中序遍历");//21534
        binaryTree.infixorder();
        System.out.println("后序遍历");//25431
        binaryTree.postorder();
    }
}

//定义BinaryTree 二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void infixorder(){
        if (this.root != null){
            this.root.infixorder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postorder(){
        if (this.root != null){
            this.root.postorder();
        }else {
            System.out.println("二叉树为空");
        }
    }
}


//先创建HeroNode节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder(){
        //输出父结点
        System.out.println(this);
        //递归向左遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixorder(){
        //递归向左遍历
        if (this.left != null){
            this.left.infixorder();
        }
        //输出父结点
        System.out.println(this);
        //递归向右遍历
        if (this.right != null){
            this.right.infixorder();
        }
    }

    //后序遍历
    public void postorder(){
        //递归向左遍历
        if (this.left != null){
            this.left.postorder();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.postorder();
        }
        //输出父结点
        System.out.println(this);
    }
}


