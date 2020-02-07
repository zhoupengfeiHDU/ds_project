package com.itheima.ds_project01._04_stack;

/**
 * 基于数组顺序栈的实现
 * 包名：com.itheima.ds_project01._04_stack 文件名：ArrayStackDemo
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 9:43
 */

public class ArrayStack {
    /**
     * 栈大小
     */
    private int size;
    /**
     *  默认栈容量
     */
    private static final int DEFAULT_CAPACITY=10;
    /**
     * 栈数据
     */
    private  Object[] elements;

    private static final int MAX_ARRAY_SIZE  = Integer.MAX_VALUE-8;

    /**
     * 默认构造创建大小为10的栈
     */
    public ArrayStack(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 通过指定大小创建栈
     * @param capacity 指定大小
     */
    public ArrayStack(int capacity){
        elements = new Object[capacity];
    }

    /**
     * 入栈
     * @param element
     * @return
     */
    public boolean push(Object element){
        try {
            checkCapacity(size+1);
            elements[size++]=element;
            return true;
        }catch (RuntimeException e){
            return false;
        }
    }

    /**
     * 检查栈容量是否还够
     */
    private void checkCapacity(int minCapacity) {
        if(elements.length - minCapacity < 0 ){
            throw  new RuntimeException("栈容量不够!");
        }
    }

    /**
     * 出栈
     * @return 出栈后的栈
     */
    public Object pop(){
        //栈为空则直接返回null
        if(size<=0){
            return null;
        }
        //弹出栈顶
        Object obj = elements[size-1];
        //弹出后赋值为null
        elements[--size] = null;
        return obj;
    }

    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    public int size(){
        return size;
    }

}