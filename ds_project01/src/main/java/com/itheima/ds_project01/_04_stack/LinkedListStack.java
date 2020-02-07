package com.itheima.ds_project01._04_stack;

/**
 * 基于链表的链式栈的实现
 * 包名：com.itheima.ds_project01._04_stack 文件名：LinkedListStack
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 11:14
 */
public class LinkedListStack {
    /**
     *   栈大小
     */
    private int size;
    /**
     * 存储链表尾节点
     */
    private Node tail;

    /**
     * 默认初始尾节点为null
     */
    public LinkedListStack() {
        this.tail = null;
    }

    /**
     * 入栈
     * @param data 入栈的数据
     * @return true：入栈成功 ，false：入栈失败
     */
    public boolean push(Object data) {
        Node newNode = new Node(tail, data, null);
        if (size > 0){
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return 出栈的数据
     */
    public Object pop() {
        if ((size-1) < 0) {
            //栈为空
            return null;
        }
        //出栈的数据
        Object data = tail.getData();
        //尾节点指向前驱节点
        tail = tail.prev;
        //尾节点的后继为null
        if (tail != null) {
            tail.next = null;
        }
        size--;
        return data;
    }

    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    public int size() {
        return size;
    }

    /**
     * 双向链表节点对象
     */
    private class Node {

        /**
         * 前驱节点
         */
        public Node prev;
        /**
         * 节点数据
         */
        private Object data;
        /***
         *后继节点
         */
        public Node next;

        /**
         * 节点默认构造函数
         * @param prev 前驱节点
         * @param data 节点数据
         * @param next 后继节点
         */
        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }
}

