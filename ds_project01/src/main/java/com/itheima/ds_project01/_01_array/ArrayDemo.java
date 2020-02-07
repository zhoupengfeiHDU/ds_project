package com.itheima.ds_project01._01_array;

/**
 * 包名：com.itheima.ds_project01._01_array 文件名：ArrayDemo
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/4 13:18
 */
public class ArrayDemo {
    public static void main(String[] args) {
        /**
         * 声明（定义）一个数组
         */
        int[] array1 = {1,2,3,4,5};
        int[] array2 = new int[5];

        /**
         * 给数组指定位置赋值
         */
        array2[0] = 1;
        array2[1] = 2;

        /**
         * 获取数组中的第i个元素array[i-1]
         */
        int element = array1[0];

        int size = array1.length;

        System.out.println(element);
        System.out.println(size);

    }
}
