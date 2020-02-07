package com.itheima.ds_project01._04_stack;

import java.util.List;
import java.util.Stack;

/**
 * 包名：com.itheima.ds_project01._04_stack 文件名：JdkStack
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 15:24
 */
public class JdkStack {
    public static void main(String[] args) {
        List list;
        //创建栈对象
        Stack stack = new Stack();
        //数据入栈
        stack.push("itcast");
        stack.push("itheima");
        //数据出栈
        Object item = stack.pop();
        System.out.println(item);
    }
}
