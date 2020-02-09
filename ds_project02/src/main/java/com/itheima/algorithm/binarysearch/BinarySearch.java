package com.itheima.algorithm.binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数据序列中存在重复元素的二分查找的变形写法
 *
 * 包名：com.itheima.algorithm.binarysearch 文件名：BinarySearch
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/9 18:47
 */
public class BinarySearch {

    /**
     * 查找数据序列中第一个等于给定值的元素的下标
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @return 不为-1：找到， -1：未找到
     */
    public int binarySearch1(int[] array, int value){
        //定义查找范围
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            //计算中间指针 mid 计算出来
            //int mid = (low + high) / 2;
            int mid = low +((high - low) >> 1);
            if (array[mid] == value){
                //之前是直接返回mid,现在要找的是第一个等于值的元素。
                // 由于数据序列是有序的,因此我们向前一位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回mid
                if (mid == 0 || array[mid - 1] != value){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }else if (array[mid] < value){
                low = mid + 1;
            }else if (array[mid] > value){
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 采用递归算法查找数据序列中第一个等于给定值的元素的下标
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @param low 数组最小索引
     * @param high 数组最大索引
     * @return 不为-1：找到， -1：未找到
     */
    public int recursionBinarySearch1(int[] array, int value, int low, int high){

        if (low >= high){
            return -1;
        }
        //计算mid指针
        int mid = (low + high) / 2;
        if (array[mid] == value){
            if (mid == 0 || array[mid - 1] != value){
                return mid;
            }else {
                return recursionBinarySearch1(array, value, low, mid-1);
            }
        }else if (array[mid] < value){
            low = mid + 1;
            return recursionBinarySearch1(array, value, low, high);
        }else {
            high = mid - 1;
            return recursionBinarySearch1(array, value, low, high);
        }
    }

    /**
     * 从数据序列中查找最后一个值等于给定值的元素
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @return 不为-1：找到， -1：未找到
     */
    public int binarySearch2(int[] array, int value){
        //定义查找的范围
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            //计算中间指针 mid 计算出来
            int mid = (low + high) / 2;
            //之前是直接返回mid,现在要找的是最后一个值等于给定值的元素
            // 由于数据序列是有序的,因此我们向前后位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回mid
            if (array[mid] == value){
                if (mid == array.length - 1 || array[mid+1] != value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else if (array[mid] > value){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 从数据序列中查找第一个大于等于给定值的元素
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @return 不为-1：找到， -1：未找到
     */
    public int binarySearch3(int[] array, int value){
        //给定区间范围
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (array[mid] >= value){
                //之前是直接返回mid,现在要找的是第一个大于等于值的元素。
                // 由于数据序列是有序的,因此我们向前一位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回mid
                if (mid == 0 || array[mid - 1] < value){
                    return mid;
                }else {
                    high = mid - 1;
                }
            } else if (array[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 从数据序列中查找最后一个小于等于给定值的元素
     * @param array 待查找的有序数组
     * @param value 要查找的数值
     * @return 不为-1：找到， -1：未找到
     */
    public int binarySearch4(int[] array, int value){
        //定义查找边界
        int low = 0;
        int high = array.length - 1;

        //玄幻判断
        while (low <= high){
            int mid = (low + high) / 2;
            if (array[mid] <= value){
                //之前是直接返回mid,现在要找的是最后一个值小于等于给定值的元素
                // 由于数据序列是有序的,因此我们向前后位查看一下是否也小于等于该值,如果小于等于则继续二分查找,否则直接返回mid
                if (mid == array.length - 1 || array[mid+1] > value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else if (array[mid] > value){
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 测试非递归方式二分查找进行对存在重复元素的第一个元素
     */
    @Test
    public void testBinarySearch1(){
        //准备一个int数组
        int[] array = {6,12,15,19,24,26,29,29,29,67};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = binarySearch1(array, 29);
        //输出查询后的结果
        System.out.println("找到了第一个目标元素的下标："+binarySearch+"---对应的值为："+array[binarySearch]);
    }

    /**
     * 测试递归方式进行存在重复元素的二分查找
     */
    @Test
    public void testRecursionBinarySearch1(){
        //准备一个int数组
        //int[] array = {6,12,15,19,24,26,29,29,29,67};
        int[] array = {0,1,2};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = recursionBinarySearch1(array, 29, 0, array.length - 1);
        //输出查询后的结果
        System.out.println("找到了第一个目标元素的下标："+binarySearch+"---对应的值为："+array[binarySearch]);
    }

    /**
     * 测试非递归方式二分查找进行对存在重复元素的最后一个元素
     */
    @Test
    public void testBinarySearch2(){
        //准备一个int数组
        int[] array = {6,12,15,19,24,26,29,29,29,67};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = binarySearch2(array, 29);
        //输出查询后的结果
        System.out.println("找到了最后一个目标元素的下标："+binarySearch+"---对应的值为："+array[binarySearch]);
    }

    /**
     * 测试非递归方式二分查找进行对存在重复元素的最后一个元素
     */
    @Test
    public void testBinarySearch3(){
        //准备一个int数组
        //int[] array = {6,12,15,19,24,26,29,29,29,67};
        int[] array = {18};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = binarySearch3(array, 17);
        //输出查询后的结果
        System.out.println("找到了第一个大于等于给定值的目标元素的下标："+binarySearch+"---对应的值为："+array[binarySearch]);
    }

    /**
     * 测试非递归方式二分查找进行对存在重复元素的最后一个元素
     */
    @Test
    public void testBinarySearch4(){
        //准备一个int数组
        int[] array = {6,12,15,19,24,26,29,29,29,67};
        //int[] array = {18};
        //输出待查找的数组
        System.out.println(Arrays.toString(array));
        //进行查找
        int binarySearch = binarySearch4(array, 20);
        //输出查询后的结果
        System.out.println("找到了最后一个小于等于给定值的目标元素的下标："+binarySearch+"---对应的值为："+array[binarySearch]);
    }
}
