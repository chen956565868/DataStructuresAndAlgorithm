package com.atguigu.hashtab;


import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出");
            System.out.println("find:查找雇员");
            System.out.println("del:删除雇员");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("id");
                    int id = scanner.nextInt();
                    System.out.println("名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    break;
                case "find":
                    System.out.println("请输入查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "del":
                    System.out.println("请输入删除的id");
                    id = scanner.nextInt();
                    hashTab.del(id);
                    break;
            }
        }
    }
}

//创建HashTab 管理多条链表
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示链表条数

    public HashTab(int size) {
        this.size = size;
        this.empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        //根据员工id加入链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加至链表
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有链表/hashtab
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //散列函数
    public int hashFun(int id){
        return id%size;
    }

    //根据输入id查找雇员
    public void findEmpById(int id){
        //使用散列函数 确定链表
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp!=null){
            System.out.println("在"+(empLinkedListNo+1)+"条链表中找到该雇员,id="+id);
        }else {
            System.out.println("没有找到");
        }
    }

    //删除雇员
    public void del(int id){
        //使用散列函数 确定链表
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].del(id);
        System.out.println("已删除");
    }
}


//表示链表
class EmpLinkedList{
    //头指针 指向第一个雇员
    private Emp head;

    //添加雇员到链表
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp curEmp = head;//辅助指针
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表
    public void list(int no){
        if (head==null){
            System.out.println("第"+(no+1)+"条链表空");
            return;
        }
        Emp curEmp = head;
            System.out.print("第"+(no+1)+"条链表信息为：  ");
        while (true){
            System.out.print("  id="+curEmp.id+",name="+curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        if (head == null){
            System.out.println("链表空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //删除雇员
    public void del(int id){
        if (head == null){System.out.println("链表空");
            return ; }
        Emp resEmp = findEmpById(id);
        if (resEmp == null){
            System.out.println("该雇员不存在 无法删除");
        }else {
            if (head.id == id){
                head = null;
                return;
            }
            Emp curEmp = head;//指向要删除雇员的上一个节点
            while (true){
                if (curEmp.next == null){
                    System.out.println("没有找到");
                    return;
                }else if (curEmp.next.id == id){
                    break;
                }
                curEmp = curEmp.next;}
            curEmp.next = resEmp.next;
            System.out.println("已删除");
        }


    }
}

//表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}