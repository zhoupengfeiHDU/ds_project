package com.itheima.ds_project01._03_queue;

/**
 * 链式队列的实现
 *
 *  1、定义链表节点的结构（单链表）
 *
 *  2、定义队列结构
 *
 *  3、定义队列操作
 *           入队列（链表的尾部添加一个元素）
 *           出队列  （链表的头节点删除）
 *
 * 包名：com.itheima.ds_project01._03_queue 文件名：LinkedListQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 17:20
 */
public class LinkedListQueue {

    /**
     * 队列元素个数
     */
    private int size;
    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾结点
     */
    private Node tail;

    /**
     * 初始化队列，首尾节点为null
     */
    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 入队
     * @param data 入队的数据
     * @return true:入队成功，false：入队失败
     */
    public boolean enqueue(Object data){
        Node node = new Node(data,null);
        if (tail == null){
            tail = node;
            head = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public Object dequeue(){
        if (head == null){
            return null;
        }
        Object data = head.data;
        //头节点后移
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return data;


    }

    /**
     * 1.定义链表节点的结构（单链表）
     */
    static class Node{
        //节点数据
        private Object data;
        //后继节点
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
