package com.itheima.ds_project01._02_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 包名：com.itheima.ds_project01._02_list 文件名：ArrayListDemo
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/4 16:11
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //向集合list中存入三个字符串元素a,b,c,d,e,f,g,h,i,j,k
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        //往集合中添加 第11个元素
        list.add("k");

        //集合中获取指定位置元素
        Object o1 = list.get(0);
        System.out.println(o1);

    }
}
