package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义逆波兰表达式  (3+4)×5-6
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        int res = calculate(list);
        System.out.println(res);
    }

    //将逆波兰表达式 的数据和运算符依次放入ArrayList
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //计算
    public static int calculate(List<String> ls){
        //创建栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : ls) {
            //使用正则表达式
            if (item.matches("\\d+")){//匹配多位数
                //入栈
                stack.push(item);
            }else {
                //pop两个数 进行运算 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res= 0;
                if (item.equals("+")){
                    res = num1+num2;
                }else if (item.equals("-")){
                    res = num1-num2;
                }else if (item.equals("*")){
                    res = num1*num2;
                }else if (item.equals("/")){
                    res = num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //结果入栈
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }



}
