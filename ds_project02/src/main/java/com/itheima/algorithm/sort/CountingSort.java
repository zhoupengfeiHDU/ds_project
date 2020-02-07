package com.itheima.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 * <p>
 * 包名：com.itheima.algorithm.sort 文件名：CountingSort
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 23:35
 */
public class CountingSort {

    public void countingSort(int[] arr) {
        //求出待排序数组的最大值,最小值,找出取值区间
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //定义一个额外的数组C
        int bucketSize = (max - min) + 1;
        int[] bucket = new int[bucketSize];

        //统计对应元素的个数,数组的下标不是单纯的值
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = arr[i] - min;
            bucket[bucketIndex] += 1;
        }


        //对数组C内元素进行累加

        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i] + bucket[i - 1];
        }

        //创建一个临时数组，存储最终有序序列
        int[] temp = new int[arr.length];

        //逆序扫描待排序数组 可保证元素的稳定性
        for (int j = arr.length - 1; j >= 0; j--) {
            int bucketIndex = arr[j] - min;
            temp[bucket[bucketIndex] - 1] = arr[j];
            bucket[bucketIndex] -= 1;
        }

        //将临时数据列表依次放入原始数组
        for (int j = 0; j < temp.length; j++) {
            arr[j] = temp[j];
        }

    }

    /**
     * 测试计数排序
     */
    @Test
    public void testCountingSort1() {
        //准备一个int数组
        int[] array = {6, 4, 5, 2, 3, 1, 8, 0, 9, 7};
        //输出排序前的结果
        System.out.println(Arrays.toString(array));
        //进行排序
        countingSort(array);
        //输出排序后的结果
        System.out.println(Arrays.toString(array));
    }

}
