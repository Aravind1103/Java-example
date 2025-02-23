package com.collections.queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {


    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(10);
        queue.add(5);
        queue.add(1);
        queue.add(6);
        queue.add(8);

        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);



    }
}
