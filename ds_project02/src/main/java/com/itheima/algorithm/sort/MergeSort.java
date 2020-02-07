package com.itheima.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序算法
 * 归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，
 * 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了
 * <p>
 * 包名：com.itheima.algorithm.sort 文件名：MergeSort
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 20:13
 */
public class MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        //将我们的数组拆分成两个部分

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0 , mid);
        int[] right = Arrays.copyOfRange(arr , mid , arr.length);

        //分解并合并
        return merge(mergeSort(left), mergeSort(right));


    }

    /**
     * 合并两个有序数组并返回新的额数组
     *
     * @param left  左边的有序数组
     * @param right 右边的有序数组
     * @return 合并后的新数组
     */
    public int[] merge(int[] left, int[] right) {

        //创建一个新的数组，这个数组的长度等于两个数组长度之和
        int[] newArray = new int[left.length + right.length];

        //定义两个指针,分别代表两个数组的下标
        int lindex = 0;
        int rindex = 0;

        for (int i = 0; i < newArray.length; i++) {
            //左半边取尽（取右半边元素）
            if (lindex >= left.length) {
                newArray[i] = right[rindex++];
                //右半边取尽（取左半边元素）
            } else if (rindex >= right.length) {
                newArray[i] = left[lindex++];
                //右半边的当前元素小于左半边的当前元素（取右半边的元素）
            } else if (right[rindex] < left[lindex]) {
                newArray[i] = right[rindex++];
                //右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
            } else {
                newArray[i] = left[lindex++];
            }
        }
        return newArray;
    }

    /**
     * 测试归并排序
     */
    @Test
    public void testMergerSort(){
        //准备一个int数组
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        //输出排序前的结果
        System.out.println(Arrays.toString(array));
        //进行排序
        array = mergeSort(array);
        //输出排序后的结果
        System.out.println(Arrays.toString(array));
    }

}
