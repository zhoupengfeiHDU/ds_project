package com.itheima.ds_project01._03_queue;

import java.util.Stack;

/**
 * 使用两个栈模拟队列操作
 * 包名：com.itheima.ds_project01._03_queue 文件名：StackQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 18:00
 */
public class StackQueue<E> {

    private Stack<E> s1 = new Stack<E>();
    private Stack<E> s2 = new Stack<E>();

    /**
     * 入队
     * @param e 入队元素
     */
    public synchronized void enQueue(E e){
        s1.push(e);
    }

    /**
     * 出队
     * @return 出队的元素
     */
    public synchronized E deQueue(){

        if (s2.isEmpty()){
            if (s1.isEmpty()){
                return null;
            }
            while (! s1.isEmpty()){
                //s1栈的栈顶数据弹出，先进后出
                E e = s1.pop();
                //将数据压入s2栈
                s2.push(e);
            }
        }
        return s2.pop();
    }

    /**
     * 队列判空
     * @return true:队列为空， false:队列不为空
     */
    public synchronized boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }

    /**
     * 获取队列当前容量
     * @return 队列当前容量
     */
    public int getCount(){
        return s1.size() + s2.size();
    }
}
