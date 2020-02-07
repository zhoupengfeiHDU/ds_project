package com.itheima.ds_project01._04_stack;

/**
 * 基于单链表实现的栈
 * 包名：com.itheima.ds_project01._04_stack 文件名：StackBasedOnLinkedList
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 11:55
 */
public class StackBasedOnLinkedList {

    /**
     *   栈大小
     */
    private int size;

    /**
     * 存储链表头节点
     */
    private Node head;

    /**
     * 初始默认头节点为null
     */
    public StackBasedOnLinkedList() {
        this.head = null;
    }

    /**
     * 入栈
     * @param data 入栈的数据
     * @return true：入栈成功， false：入栈失败
     */
    public boolean push(Object data) {
        Node newNode = new Node(data, head);
        head = newNode;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return 出栈的数据
     */
    public Object pop(){
        if (head == null){
            return null;
        }
        Node topNode = head;
        head = topNode.next;
        topNode.next = null;
        size--;
        return topNode.data;
    }

    /**
     * 获取栈的大小
     * @return 栈的大小
     */
    public int size() {
        return size;
    }

    /**
     * 单向链表节点对象
     */
    private static class Node {
        //节点数据
        private Object data;
        //next 指针
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }
    }
}
