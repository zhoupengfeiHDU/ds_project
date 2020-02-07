package com.itheima.ds_project01._03_queueTest;

import com.itheima.ds_project01._03_queue.LinkedListQueue;
import org.junit.Test;

/**
 * 包名：com.itheima.ds_project01._03_queueTest 文件名：TestLinkedListQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 17:39
 */
public class TestLinkedListQueue {
    @Test
    public void test1(){
        LinkedListQueue queue = new LinkedListQueue();
        //System.out.println(queue.dequeue());
        queue.enqueue("队列1");
        queue.enqueue("队列2");
        queue.enqueue("队列3");
        queue.enqueue("队列4");
        System.out.println(queue.dequeue());//队列1
        System.out.println(queue.dequeue());//队列2
        System.out.println(queue.dequeue());//队列3
        System.out.println(queue.dequeue());//队列4
        System.out.println(queue.dequeue());//null
        queue.enqueue("队列5");
        queue.enqueue("队列6");
        System.out.println(queue.dequeue());//队列5
        System.out.println(queue.dequeue());//队列6

    }
}
