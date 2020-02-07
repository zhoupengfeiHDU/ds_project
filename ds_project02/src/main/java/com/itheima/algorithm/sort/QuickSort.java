package com.itheima.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 *  快速排序
 *
 *  1 从我们的数据序列中找到一个分区点 【基准点】 pivot
 *  2、重新排序数列，所有元素和 基准点元素比较
 *      比基准点小  左边   比基准点大 右边
 *  3、递归 左边   和  右边
 *
 * 包名：com.itheima.algorithm.sort 文件名：QuickSort
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 21:50
 */
public class QuickSort {

    /**
     * 快速排序
     * 借助递归和分区的思想来实现
     * @param arr 待排序的序列
     * @param begin 起始位置
     * @param end 结束位置
     */
    public void quickSort(int[] arr, int begin, int end){
        //校验:递归终止条件
        if (arr.length <= 1 || begin >= end){
            return;
        }
        //进行分区，得到分区的下标
        int piovtIndex = partition(arr, begin, end);

        //递归（对分区左侧进行快排）
        quickSort(arr, begin, piovtIndex - 1);
        //递归（对分区右侧进行快排）
        quickSort(arr, piovtIndex + 1, end);

    }

    /**
     * 返回我们某一个序列的基准点(分区函数)
     * @param arr 序列
     * @param begin 起始
     * @param end 结束
     * @return 返回基准点索引piovtIndex
     */
    private int partition(int[] arr, int begin, int end){
        //默认数组中待分区区间的最后一个是pivot元素 当然也可以随机指定pivot元素
        int pivot = arr[end];
        //定义分区后pivot元素的下标
        int piovtIndex = begin;
        for (int i = begin; i < end; i++) {
            //判断如果该区间内如果有元素小于pivot,则将该元素从区间头开始一直向后填充,有点类似选择排序
            if (arr[i] < pivot){
                if (i > piovtIndex){
                    swap(arr, i, piovtIndex);
                }
                piovtIndex++;
            }
        }

        swap(arr, piovtIndex, end);
        //返回基准点
        return piovtIndex;
    }

    /**
     * 交换数组内下标为i j的两个元素
     * @param arr 待交换的数组
     * @param i 数组下标i
     * @param j 数组下标j
     */
    private void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 测试快速排序
     */
    @Test
    public void testQuickSort(){
        //准备一个int数组
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        //输出排序前的结果
        System.out.println(Arrays.toString(array));
        //进行排序
        quickSort(array, 0, array.length-1);
        //输出排序后的结果
        System.out.println(Arrays.toString(array));
    }
}



