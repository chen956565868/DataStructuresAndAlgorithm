package com.atguigu.tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadNodes();

//        HeroNode leftNode = node5.getLeft();
//        System.out.println(leftNode);
//        HeroNode rightNode = node5.getRight();
//        System.out.println(rightNode);

        //遍历线索化二叉树
        threadedBinaryTree.threadList();
    }
}

//定义ThreadedBinaryTree 实现线索化功能的二叉树
class ThreadedBinaryTree{
    private HeroNode root;
    //指向当前结点的前驱结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //中序线索化
    public void threadNodes(){
        this.threadNodes(root);
    }

    //中序线索化
    public void threadNodes(HeroNode node){
        if (node == null){
            return;
        }
        //线索化左子树
        threadNodes(node.getLeft());
        //线索化当前节点
        //处理当前结点的前驱结点
        if (node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre != null && pre.getRight() == null){
            //前驱结点右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的类型
            pre.setRightType(1);
        }
        //让当前结点是下一个结点的前驱结点
        pre = node;
        //线索化右子树
        threadNodes(node.getRight());
    }

    //遍历中序线索化二叉树
    public void threadList(){
        //存储当前遍历的结点
        HeroNode node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            //打印当前结点
            System.out.println(node);
            //如果当前结点的右指针是后继节点 就一直输出
            while (node.getRightType() == 1){
                //获取到当前结点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
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

    //0：指向子树    1：指向前驱/后继结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

