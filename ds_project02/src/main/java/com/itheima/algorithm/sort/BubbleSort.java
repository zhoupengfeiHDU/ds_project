package com.itheima.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;


/**
 *  冒泡排序算法
 *   冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 *   走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 *   这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
 *
 *   步骤:
 *    1：比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 *    2：对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 *    3：针对所有的元素重复以上的步骤，除了最后一个；
 *    4：重复步骤1~3，直到排序完成。
 *
 * 包名：com.itheima.algorithm.sort 文件名：BubbleSort
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/7 16:00
 */
public class BubbleSort {
    /**
     * 冒泡排序算法
     * @param array 待排序的数组
     */
    public void bubbleSort1(int[] array){
        //待排序元素的个数
        int length = array.length;
        int count = 0;
        if (length <= 1){
            return;
        }
        //冒泡排序
        for (int i = 0; i < length; i++) {
            //相邻元素比较
            for (int j = 0; j < length - i - 1; j++) {
                //判断前后数据是否需要交换 如果前一个数据大于后一个数据则进行交换否则不交换
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println("交换次数：" + count);
    }

    /**
     * 测试冒泡排序
     */
    @Test
    public void bubbleSort1Test(){
        //准备一个int数组
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        //进行排序
        System.out.println(Arrays.toString(array));
        bubbleSort1(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));


    }

    /**
     * 冒泡排序优化
     * @param array 待排序的数组
     */
    public void bubbleSort2(int[] array){
        int len = array.length;
        int count = 0;
        if (len <= 1){
            return;
        }
        //开始冒泡
        for (int i = 0; i < len; i++) {
            //是否需要提前结束冒泡的标识
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++) {
                //判断前后数据是否需要交换 如果前一个数据大于后一个数据则进行交换否则不交换
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    count++;

                    flag = false;
                }
            }
            //在当前这次冒泡中如果所有元素都不需要进行交换则证明所有元素都已有序,则无需进行后续的冒泡操作了
            if (flag){
                break;
            }
        }
        System.out.println("交换次数：" + count);
    }

    /**
     * 测试优化后的冒泡排序
      */
    @Test
    public void testBubbleSort2(){
        //准备一个int数组
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        //进行排序
        System.out.println(Arrays.toString(array));
        bubbleSort2(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     */
    public static void bubbleSort3(int[] a, int n) {
        int count = 0;
        if (n <= 1) {
            return;
        }

        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                    count ++;
                }
            }
            sortBorder = lastExchange;
            if (!flag) {
                break;    // 没有数据交换，提前退出
            }
        }
        System.out.println("交换次数：" + count);
    }

    /**
     * 测试bubbleSort3
     */
    @Test
    public void testBubbleSort3(){
        int[] array = {6,4,5,2,3,1,8,0,9,7};
        bubbleSort3(array,6);
        System.out.println(Arrays.toString(array));
    }
}
