package com.atguigu.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
//        int[] arr = {10,12,8,9,7,6};
        int[] arr = { 10, 11, 7, 6, 8, 9 };
//        int[] arr = {2,1,6,5,7,3};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println("---------------");
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());
        System.out.println("--------------");
        System.out.println(avlTree.getRoot());
//        System.out.println("旋转之后");
//        avlTree.getRoot().leftRotate();
//        System.out.println("树的高度：" + avlTree.getRoot().height());
//        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
//        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());
    }
}

//AVLTree
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //查找要删除的结点
    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     * @param node  传入的结点
     * @return  返回以node为根节点的最小结点的值 并删除该最小节点
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环查找左结点 找到最小值
        while (target.left != null){
            target = target.left;
        }//此时target指向最小结点
        delNode(target.value);//删除最小节点
        return target.value;
    }

    //删除结点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //找到要删除的结点
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            //可能存在重复数据 所以不能root.value==value
            //如果这棵二叉树只有一个结点
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            //找到要删除的结点的父结点
            Node parent = searchParent(value);
            //第一种情况：如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null){
                //判断targetNode是父结点的左子结点还是右子结点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
            }else if (targetNode.left != null && targetNode.right != null){
                //第二种情况：删除有两棵子树的结点
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            }else {
                //第三种情况：删除只有一棵子树的结点
                if (parent != null){
                    if (parent.left != null && parent.left.value == value){
                        if (targetNode.left != null){
                            parent.left = targetNode.left;
                        }else if (targetNode.right != null){
                            parent.left = targetNode.right;
                        }
                    }else if (parent.right != null && parent.right.value == value){
                        if (targetNode.left != null){
                            parent.right = targetNode.left;
                        }else if (targetNode.right != null){
                            parent.right = targetNode.right;
                        }
                    }
                }else {//只有两颗结点 且要删除根节点
                    root = targetNode.left == null ? targetNode.right : targetNode.left;
                }
            }
        }
    }

    //添加节点
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("树空");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }else {
            return left.height();
        }
    }

    //返回右子树的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }else {
            return right.height();
        }
    }

    //返回当前结点子树的高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    //左旋转
    public void leftRotate(){
        //创建等值新结点
        Node newNode = new Node(this.value);
        //把新结点的左结点指向当前结点的左结点
        newNode.left = this.left;
        //把新结点的右结点指向当前结点的右结点的左结点
        newNode.right = this.right.left;
        //把当前结点的值替换为右结点的值
        this.value = this.right.value;
        //当前结点的右结点指向右结点的右结点
        this.right = this.right.right;
        //当前结点的左结点指向新结点
        this.left = newNode;
    }

    //右旋转
    public void rightRotate(){
        //创建等值新结点
        Node newNode = new Node(this.value);
        //把新结点的右结点指向当前结点的右结点
        newNode.right = this.right;
        //把新结点的左结点指向当前结点的左结点的右结点
        newNode.left = this.left.right;
        //把当前结点的值替换为左结点的值
        this.value = this.left.value;
        //当前结点的左结点指向左结点的左结点
        this.left = this.left.left;
        //当前结点的右结点指向新结点
        this.right = newNode;
    }

    /**查询要删除的结点
     * @param value 希望要删除的结点的值
     * @return  返回该结点
     */
    public Node search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            //向左子树递归查找
            if (this.left != null){
                return this.left.search(value);
            }else {
                return null;
            }
        }else {
            //向左子树递归查找
            if (this.right != null){
                return this.right.search(value);
            }else {
                return null;
            }
        }
    }

    /**查找要删除结点的父结点
     * @param value 想要删除的结点的值
     * @return 返回该结点的父节点
     */
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            if (this.value > value && this.left != null){
                //向左子树递归查找
                return this.left.searchParent(value);
            }else if (this.value <= value && this.right != null){
                //向右子树递归查找
                return this.right.searchParent(value);
            }else {
                return null;//没有找到父结点
            }
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //递归添加结点(满足二叉排序树)
    public void add(Node node){
        if (node == null){
            return;
        }
        //判断传入结点的值 和当前子树根节点的关系
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {//递归向左添加
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
        //(右子树的高度-左子树的高度)>1
        if (rightHeight() - leftHeight() > 1){
            //如果右子树的左子树的高度>右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()){
                //先对当前结点的右子树 右旋转
                this.right.rightRotate();
                //再对当前结点进行左旋转
                this.leftRotate();
            }else {
                leftRotate();//左旋转
            }//(左子树的高度-右子树的高度)>1
        }else if (leftHeight() - rightHeight() > 1){
            //如果左子树的右子树的高度>左子树的左子树的高度
            if (left != null && left.rightHeight() > left.leftHeight()){
                //先对当前结点的左子树 左旋转
                this.left.leftRotate();
                //再对当前结点进行右旋转
                this.rightRotate();
            }else {
                rightRotate();//直接右旋转
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}