package com.itheima.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 *   选择排序算法
 *   选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会
 *    从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 *
 * 包名：com.itheima.algorithm.sort 文件名：SelectionSort
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 19:14
 */
public class SelectionSort {

    public void selectionSort(int[] arr){

        //待排序数组的长度
        int len = arr.length;
        //交换的次数
        int count = 0;

        if (len <= 1){
            return;
        }
        for (int i = 0; i < len; i++) {

            int minIndex = i;
            //从未排序的序列中找到最小值
            for (int j = i + 1; j < len ; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //交换未排序区间最小元素和当前元素的位置
            int current = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = current;
            count++;

        }
        System.out.println("交换次数：" + count);
    }

    /**
     * 测试选择排序
     */
    @Test
    public void testSelectionSort(){
        //准备一个int数组
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        //输出排序前的结果
        System.out.println(Arrays.toString(array));
        //进行排序
        selectionSort(array);
        //输出排序后的结果
        System.out.println(Arrays.toString(array));
    }
}
