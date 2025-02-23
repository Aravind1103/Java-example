package com.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {


    public static class Worker implements Runnable {
        private final CountDownLatch latch;
        private final List<String> output;

        public Worker(CountDownLatch latch, List<String> output) {
            this.latch = latch;
            this.output = output;
        }

        @Override
        public void run() {
            output.add("Latch Countdown");
            latch.countDown();
        }
    }

    public static class WaitingWorker implements Runnable {
        private final CountDownLatch start;
        private final CountDownLatch end;
        private final CountDownLatch block;
        private final List<String> output;

        public WaitingWorker(CountDownLatch start, CountDownLatch end, CountDownLatch block, List<String> output) {
            this.start = start;
            this.end = end;
            this.block = block;
            this.output = output;
        }

        @Override
        public void run() {
            start.countDown();
            output.add(Thread.currentThread().getName() + "Ready to Start");
            System.out.println(Thread.currentThread().getName() + "Ready to Start");
            try {
                block.await();
                System.out.println(Thread.currentThread().getName() + "Started");
                output.add(Thread.currentThread().getName() + "Started");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                end.countDown();
                System.out.println(Thread.currentThread().getName() + "Completed");
                output.add(Thread.currentThread().getName() + "Completed");
            }
        }
    }

    /*public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<String> output = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Worker> workers = Stream.generate(() -> new Worker(countDownLatch,output)).limit(5).collect(Collectors.toList());
        workers.forEach(executor::submit);
        countDownLatch.await();
        output.add("Latch Done");
        shutDownExecutor(executor);
        System.out.println(output);
    }*/

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<String> output = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch start = new CountDownLatch(5);
        CountDownLatch end = new CountDownLatch(5);
        CountDownLatch block = new CountDownLatch(1);
        List<WaitingWorker> workers = Stream.generate(() -> new WaitingWorker(start,end,block,output)).limit(5).collect(Collectors.toList());
        workers.forEach(executor::submit);
//        List<Thread> workers = Stream
//                .generate(() -> new Thread(new WaitingWorker(start,end,block,output)))
//                .limit(5)
//                .collect(toList());
//        workers.forEach(Thread::start);

        start.await();
        System.out.println("Signaled to Start");
        block.countDown();
        end.await();
        output.add("Latch Done");
        shutDownExecutor(executor);
        System.out.println(output);
    }

    public static void shutDownExecutor(ExecutorService executorService){
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
