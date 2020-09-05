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

//        System.out.println("前序遍历");//12354
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");//21534
//        binaryTree.infixorder();
//
//        System.out.println("后序遍历");//25431
//        binaryTree.postorder();

//        System.out.println("前序遍历查询");
//        HeroNode resNode = binaryTree.preOrderSearch(5);

//        System.out.println("中序遍历查询");
//        HeroNode resNode = binaryTree.infixOrderSearch(5);

//        System.out.println("后序遍历查询");
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null){
//            System.out.println("找到no="+resNode.getNo()+"，name="+resNode.getName());
//        }else {
//            System.out.println("没有找到");
//        }
        System.out.println("删除前");//12354
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后");//1234
        binaryTree.preOrder();
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

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (root != null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    //后序遍历
    public HeroNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    //删除结点
    public void delNode(int no){
        if (root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树");
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

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //比较当前结点
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        //则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){//左子树找到
            return resNode;
        }
        //当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        //判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        //和当前结点比较
        if (this.no == no){
            return this;
        }
        //继续进行右递归的中序查找
        if (this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历
    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        //判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        if (this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null){//说明在左子树找到
            return resNode;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){//说明在右子树找到
            return resNode;
        }
        //比较当前结点是
        if (this.no == no){
            return this;
        }
        return resNode;
    }

    //递归删除结点
    public void delNode(int no){
        //判断左子结点
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //判断右子结点
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //向左递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        //向右递归删除
        if (this.right != null){
            this.right.delNode(no);
        }
    }
}


