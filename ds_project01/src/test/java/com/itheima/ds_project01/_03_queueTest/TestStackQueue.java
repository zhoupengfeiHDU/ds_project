package com.itheima.ds_project01._03_queueTest;

import com.itheima.ds_project01._03_queue.StackQueue;
import org.junit.Test;

/**
 * 包名：com.itheima.ds_project01._03_queueTest 文件名：TestStackQueue
 *
 * @author 周鹏飞
 * @version 1.0
 * @date 2020/2/6 18:09
 */
public class TestStackQueue {

    @Test
    public void test1(){
        StackQueue<Integer> queue = new StackQueue<>();
        System.out.println("出队列：" + queue.deQueue());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("出队列：" + queue.deQueue());//1
        System.out.println("出队列：" + queue.deQueue());//2
        System.out.println("出队列：" + queue.deQueue());//3
        System.out.println("出队列：" + queue.deQueue());//null
        System.out.println("当前队列的长度" + queue.getCount());//0
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println("当前队列的长度" + queue.getCount());//2
    }
}
