package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        //创建数栈 符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义变量
        int index = 0;//用于扫描字符串
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//保存每次扫描得到的char
        String keepNum = "";//拼接多位数
        //开始扫描
        while (true){
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch
            if (operStack.isOper(ch)){
                //判断符号栈是否为空
                if (!operStack.isEmpty()){
                    //不为空 判断优先级
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        //如果优先级小于等于 需要pop两个数字进行运算 结果入数栈 当前符号入栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //运算结果入数栈
                        numStack.push(res);
                        //当前符号入栈
                        operStack.push(ch);
                    }else {//当前符号优先级大于栈顶符号
                        //当前符号入栈
                        operStack.push(ch);
                    }
                }else {
                    //符号栈为空
                    //当前符号入栈
                    operStack.push(ch);
                }
            }else {
                //是数字 入数栈
                //numStack.push(ch -48);
                //多看一位 如果是数就继续扫描 是符号就入数栈
                //处理多位数
                keepNum += ch;
                //如果ch是expression最后一位 不需要多看 直接入栈
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {//不是最后一位
                    //判断下一位是否为数字
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //后一位是操作符
                        numStack.push(Integer.parseInt(keepNum));
                        //清空keepNum
                        keepNum = "";
                    }
                }
            }
            //index+1 判断是否扫描到字符串最后
            index++;
            if (index >=expression.length()){
                break;
            }
        }
        //扫描完毕 顺序取数字和符号 进行运算
        while (true){
            //若符号栈为空 计算结束 数栈出结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println("表达式："+expression+"的结果："+numStack.pop());
    }
}

//先创建栈
class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶 初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //返回栈顶的值 不出栈
    public int peek(){
        return stack[top];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //判断栈满
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        //判断栈空
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈 从栈顶开始显示
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.println("stack["+i+"]"+"="+stack[i]);
        }
    }

    //返回运算符的优先级 自定义优先级
    //优先级使用数字表示 数字大优先级高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;//计算结果
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }






}
