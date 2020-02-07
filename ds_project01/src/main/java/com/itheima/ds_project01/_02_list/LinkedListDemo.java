package com.itheima.ds_project01._02_list;

import java.util.LinkedList;
import java.util.List;

/**
 * 演示LinkedList链表源码分析
 * 包名：com.itheima.ds_project01._02_list 文件名：LinkedListDemo
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/5 12:10
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        //构建容器
        List<String> list = new LinkedList<String>();
        //向容器中添加数据
        list.add("元素1");
        list.add("元素2");
        list.add("元素3");
        list.add("元素4");

        String s = list.get(2);
        System.out.println(s);

    }
}
