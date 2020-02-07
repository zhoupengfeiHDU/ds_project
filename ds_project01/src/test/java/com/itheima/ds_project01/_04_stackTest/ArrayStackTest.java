package com.itheima.ds_project01._04_stackTest;

import com.itheima.ds_project01._04_stack.ArrayStack;
import org.junit.Test;

/**
 * 测试基于数组顺序栈的实现
 * 包名：com.itheima.ds_project01._04_stackTest 文件名：ArrayStackTest
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 12:40
 */
public class ArrayStackTest {

    @Test
    public void test1(){
        ArrayStack stack = new ArrayStack(11);
        System.out.println(stack.size());
        //压栈
        for (int i = 0; i < 13; i++) {
            boolean push = stack.push(i);
            System.out.println("第"+(i+1)+"次存储数据为："+i+",存储结果是："+push);
        }
        System.out.println(stack.size());

        //出栈
        for (int i = 0; i < 11; i++) {
            Object pop = stack.pop();
            System.out.println("第"+(i+1)+"次弹出的数据为："+pop);
        }

    }
}
