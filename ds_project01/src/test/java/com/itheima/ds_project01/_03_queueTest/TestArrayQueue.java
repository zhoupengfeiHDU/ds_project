package com.itheima.ds_project01._03_queueTest;

import com.itheima.ds_project01._03_queue.ArrayQueue;
import org.junit.Test;

/**
 * 包名：com.itheima.ds_project01._03_queueTest 文件名：TestArrayQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 16:52
 */
public class TestArrayQueue {
    @Test
    public void test1(){
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue("队列1");
        queue.enqueue("队列2");
        queue.enqueue("队列3");
        queue.enqueue("队列4");
        //此时入队列一个走扩容的逻辑
        queue.enqueue("队列5");
        queue.enqueue("队列6");
        //出队列
        System.out.println(queue.dequeue());//队列1
        System.out.println(queue.dequeue());//队列2
        //此时入队列应该走数据搬移逻辑
        queue.enqueue("队列7");
        // 出队列
        System.out.println(queue.dequeue());//队列3
        //入队列
        queue.enqueue("队列8");
        //出队列
        System.out.println(queue.dequeue());//队列4
        System.out.println(queue.dequeue());//队列5
        System.out.println(queue.dequeue());//队列6
        System.out.println(queue.dequeue());//队列7
        System.out.println(queue.dequeue());//队列8
        System.out.println(queue.dequeue());//null
        //入队列
        queue.enqueue("队列9");
        queue.enqueue("队列10");
        queue.enqueue("队列11");
        queue.enqueue("队列12");
        //出队列
        System.out.println(queue.dequeue());//队列9
        System.out.println(queue.dequeue());//队列10
    }
}
