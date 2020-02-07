package com.itheima.ds_project01._03_queue;

import java.util.Arrays;

/**
 * 基于数组实现的顺序队列：
 * 包名：com.itheima.ds_project01._03_queue 文件名：ArrayQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 15:38
 */
public class ArrayQueue {
    /**
     * 定义队列的结构
     * 使用数组来存储我们的队列结构
     */
    private Object[] elements;
    /**
     * 定义队列的大小
     */
    private int size;
    /**
     * 定义队列的初始容量为10
     */
    private int DEFAULT_CAPACITY = 10;
    /**
     * 定义一个容量的最大值
     */
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * 定义队列的头指针
     */
    private int head;
    /**
     * 定义尾指针
     */
    private int tail;

    /**
     * 默认构造函数 初始化大小为10的队列
     */
    public ArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
        //初始化首尾指针
        initPoint(0,0);
    }

    /**
     * 通过传入的容量大小创建队列
     * @param capcity
     */
    public ArrayQueue(int capcity){
        if (capcity <= 0){
            throw new RuntimeException("队列的初始容量有问题！");
        }
        elements = new Object[capcity];
        initPoint(0,0);
    }

    /**
     * 初始化队列头尾指针
     * @param head 头指针
     * @param tail 尾指针
     */
    private void initPoint(int head, int tail){
        this.head = head;
        this.tail = tail;
    }

    //定义结构上的操作（算法）

    /**
     * 入队列【支持动态扩容】
     * @return true:入队成功，false：入队失败
     */
    public boolean enqueue(Object element){
        //校验队列容量是否够用
        ensureCapacityHelper();
        //队列尾部加入element
        elements[tail++] = element;
        size++;
        return true;
    }

    public Object dequeue(){
        //队列中没有数据
        if (head == tail){
            return null;
        }
        ////取出队列头的元素且头指针后移
        Object obj = elements[head++];
        //队列中元素个数减1
        size--;
        return obj;
    }

    /**
     * 动态扩容机制
     * 1.判断队列容量是否够用
     */

    private void ensureCapacityHelper(){
        //尾指针已经越过队列的尾部
        if(tail==elements.length){
            // 判断队列是否已满 即判断数组中是否还有可用存储空间
           if (size <= elements.length){
            if (head == 0){
                //扩容
                grow(elements.length);
            }else {
                //进行数据搬移操作 将数组中的数据依次向前挪动直至顶部
                for (int i = head; i < tail; i++) {
                    elements[i-head] = elements[i];
                }
                //数据搬移完后重新初始化头尾指针
                initPoint(0,tail-head);
            }
           }
        }
    }

    /**
     * 扩容方法
     * @param oldCapacity 原始容量
     */
    private void grow(int oldCapacity){
        //扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //首次0-0=0;使用默认容量
        if (newCapacity - oldCapacity < 0){
            newCapacity = DEFAULT_CAPACITY;
        }
        //新扩容的容量超过Integer的最大值
        if (newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(newCapacity);
        }
        elements = Arrays.copyOf(elements,newCapacity);
    }

    /**
     *超过Integer大容量处理
     * @param newCapacity 扩容后大小
     * @return 处理后的容量大小
     */
    private int hugeCapacity(int newCapacity){
        return (newCapacity > MAX_ARRAY_SIZE)?Integer.MAX_VALUE - 8 : newCapacity;
    }
}
