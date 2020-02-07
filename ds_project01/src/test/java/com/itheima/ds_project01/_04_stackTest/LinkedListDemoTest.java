package com.itheima.ds_project01._04_stackTest;

import com.itheima.ds_project01._04_stack.LinkedListStack;
import com.itheima.ds_project01._04_stack.StackBasedOnLinkedList;
import org.junit.Test;

/**
 * 包名：com.itheima.ds_project01._04_stackTest 文件名：LinkedListDemoTest
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 11:44
 */
public class LinkedListDemoTest {
    /**
     * 测试双向链表构成的栈
     */
    @Test()
    public void test1(){
        LinkedListStack stack = new LinkedListStack();
        System.out.println("栈中数据的长度："+stack.size());
        stack.push(1);
        stack.push(2);
        System.out.println("栈中数据的长度："+stack.size());
        Object pop1 = stack.pop();
        System.out.println(pop1);
        System.out.println("栈中数据的长度："+stack.size());
        Object pop2 = stack.pop();
        System.out.println(pop2);
        System.out.println("栈中数据的长度："+stack.size());
    }

    /**
     * 测试单向链表构成的栈
     */
    @Test()
    public void test2(){
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        System.out.println("栈中数据的长度："+stack.size());
        stack.push(1);
        stack.push(2);
        System.out.println("栈中数据的长度："+stack.size());
        Object pop1 = stack.pop();
        System.out.println(pop1);
        System.out.println("栈中数据的长度："+stack.size());
        Object pop2 = stack.pop();
        System.out.println(pop2);
        System.out.println("栈中数据的长度："+stack.size());
    }
}
