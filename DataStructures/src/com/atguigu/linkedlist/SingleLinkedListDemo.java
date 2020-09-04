package com.atguigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list1.addByOrder(hero1);
        list1.addByOrder(hero3);
        list2.addByOrder(hero2);
        list2.addByOrder(hero4);
        list1.list();
        System.out.println("------------");
        list2.list();
        System.out.println("------------");
        SingleLinkedList newList = merge(list1, list2);
        newList.list();

//        HeroNode heroNode = new HeroNode(2,"小卢","yuqilin");
//        singleLinkedList.update(heroNode);
//        singleLinkedList.list();
//        System.out.println("-------------------");
//        System.out.println(getLength(singleLinkedList.getHead()));
//        System.out.println("-------------------");
//        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 5);
//        System.out.println(lastIndexNode);
//        System.out.println("-------------------");
//        reversetList(singleLinkedList.getHead());
//        System.out.println(singleLinkedList);
    }

    //合并两个有序的单链表，合并之后的链表依然有序
    public static SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2) {
        HeroNode h1 = list1.getHead().next;
        HeroNode h2 = list2.getHead().next;
        if (h1==null){
            return list2;
        } else if (h2==null) {
            return list1;
        }
        SingleLinkedList newList = new SingleLinkedList();
        HeroNode temp = null;
        if (list1.getHead().no<=list2.getHead().no){
            temp = list1.getHead();
        }else {
            temp = list2.getHead();
        }
        HeroNode head = temp;
        while (h1 != null && h2 != null){
            if (h1.no <= h2.no){
                temp.next = h1;
                h1 = h1.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        //两个链表至少有一个为null
        if (h1==null){
            temp.next = h2;
        }
        if (h2==null){
            temp.next = h1;
        }
        newList.setHead(head);
        return newList;
    }



    //将单链表反转
    public static void reversetList(HeroNode head) {
        if (head.next==null || head.next.next==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");;
        while (true){
            if (cur == null){
                break;
            }
            next = cur.next;
//            reverseHead.next = cur.next;
            cur.next = reverseHead.next;
//            cur.next = cur;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //查找链表的倒数第K个节点
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
    //初始化头节点 不存放数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加节点到单项列表
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表
        while (true){
            if (temp.next == null){ //链表的最后
               break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //按顺序添加节点
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;//添加的编号是否存在 默认false
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;//编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("数据已存在");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息
    public void update(HeroNode heroNode){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.println("没有找到");
        }
    }

    // 遍历 显示链表
    public void list(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            //判断非空
            if (temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
