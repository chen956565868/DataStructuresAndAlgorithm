package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};//
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
        binarySortTree.delNode(1);
        binarySortTree.delNode(3);
        binarySortTree.delNode(5);
        binarySortTree.delNode(7);
        binarySortTree.delNode(9);
        binarySortTree.delNode(10);
        binarySortTree.delNode(12);
        System.out.println("---------");
        binarySortTree.infixOrder();
    }
}

//创建二叉排序树
class BinarySortTree{
    private Node root;

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
