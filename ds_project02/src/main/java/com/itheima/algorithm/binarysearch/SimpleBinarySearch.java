package com.itheima.algorithm.binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 有序数列中不存在重复元素的二分查找
 *
 * 包名：com.itheima.algorithm.binarysearch 文件名：SimpleBinarySearch
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/9 12:24
 */
public class SimpleBinarySearch {

    /**
     * 使用非递归的形式查找
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @return mid != -1：找到， -1：未找到
     */
    public int binarySearch(int[] array, int value){

        int low = 0;
        int high = array.length - 1;

        while (low < high){
            //计算中间元素的下标
            int mid = (low + high) / 2;
            if (array[mid] == value){
                System.out.println("找到元素："+value+",索引下标为：" + mid);
                return mid;
            }else if (array[mid] < value ){
                low = mid + 1;
            }else if (array[mid] > value){
                high = mid - 1;
            }
        }
        //如果至此还未找到则返回-1代表未找到匹配的元素
        return -1;

    }

    /**
     *使用递归的形式查找
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @param low 数组最小索引
     * @param high 数组最大索引
     * @return 不为-1：找到， -1：未找到
     */
    public int recursionBinarySearch(int[] array, int value, int low, int high){

        if (low >= high){
            return -1;
        }

        //计算mid指针
        int mid = (low + high) / 2;
        if (array[mid] == value ){
            System.out.println("找到元素："+value+",索引下标为：" + mid);
            return mid;
        }else if (value > array[mid]){
            return recursionBinarySearch(array,value,mid+1,high);
        }else {
            return recursionBinarySearch(array,value,low,mid-1);
        }
    }

    /**
     * 测试非递归方式的二分查找
     */
    @Test
    public void testBinarySearch(){
        //准备一个int数组
        int[] array = {6,12,15,19,24,26,29,35,46,67};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = binarySearch(array, 15);
        //输出查询后的结果
        System.out.println(binarySearch);
    }

    /**
     * 测试递归方式的二分查找
     */
    @Test
    public void testRecursionBinarySearch(){
        //准备一个int数组
        //int[] array = {6,12,15,19,24,26,29,35,46,67};
        int[] array = {0,1};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = recursionBinarySearch(array, 16, 0, array.length - 1);
        //输出查询后的结果
        System.out.println(binarySearch);
    }
}
