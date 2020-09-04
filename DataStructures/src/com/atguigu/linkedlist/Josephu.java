package com.atguigu.linkedlist;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println("------------------");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建环形单向链表
class CircleSingleLinkedList{
    //创建first节点
    private Boy first = null;
    //添加节点 构建环形链表
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums不正确");
            return;
        }
        Boy curBoy = null;//辅助指针 帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.setNext(first);//构成环状
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy(){
        if (first == null){
            System.out.println("链表为空");
        }
        Boy curBoy = first;
        while (true){
            System.out.println("编号："+curBoy.getNo());
            if (curBoy.getNext()==first){
                System.out.println("结束");
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入 计算小孩出圈的顺序
    public void countBoy(int startNo,int countNum,int nums){
        if (first == null || startNo < 1 || startNo >nums){
            System.out.println("参数有误");
            return;
        }
        //创建辅助指针 让helper指向链表的最后节点
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //让指针移动到开始报数的小孩上
        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //开始报数 出圈
        while (true){
            if (helper==first){//只有一个人
                break;
            }
            //让first helper移动countNum-1次 然后出圈
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first小孩出圈
            System.out.println("小孩"+first.getNo()+"出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后小孩是"+first.getNo());
    }




}


//创建Boy类 表示一个节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
