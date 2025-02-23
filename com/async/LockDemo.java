package com.async;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static class DeadLock {
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void method1() {
            synchronized (lock1) {
                System.out.println("lock1 acquired by " + Thread.currentThread().getName());
                synchronized (lock2) {
                    System.out.println("lock2 also acquired by " + Thread.currentThread().getName());
                }
            }
        }

        public void method2() {
            synchronized (lock2) {
                System.out.println("lock2 acquired by " + Thread.currentThread().getName());
                synchronized (lock1) {
                    System.out.println("lock1 also acquired by " + Thread.currentThread().getName());
                }
            }
        }
    }

    // Lock Ordering
    public static class DeadLockSolution1 extends DeadLock {
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void method1() {
            synchronized (lock1) {
                System.out.println("lock1 acquired by " + Thread.currentThread().getName());
                synchronized (lock2) {
                    System.out.println("lock2 also acquired by " + Thread.currentThread().getName());
                }
            }
        }

        public void method2() {
            synchronized (lock1) {
                System.out.println("lock1 acquired by " + Thread.currentThread().getName());
                synchronized (lock2) {
                    System.out.println("lock2 also acquired by " + Thread.currentThread().getName());
                }
            }
        }
    }

    // ReentrantLock Ordering
    public static class DeadLockSolution2 extends DeadLock {
        private final ReentrantLock lock1 = new ReentrantLock();
        private final ReentrantLock lock2 = new ReentrantLock();

        public void method1() {
            try {
                if (lock1.tryLock(5, TimeUnit.SECONDS)) {
                    System.out.println("lock1 acquired by " + Thread.currentThread().getName());
                    try {
                        if (lock2.tryLock(5, TimeUnit.SECONDS)) {
                            try {
                                System.out.println("lock2 also acquired by " + Thread.currentThread().getName());
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("unable acquired lock2 also by " + Thread.currentThread().getName());
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("unable acquired lock1 by " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        public void method2() {
            try {
                if (lock1.tryLock(5, TimeUnit.SECONDS)) {
                    System.out.println("lock1 acquired by " + Thread.currentThread().getName());
                    if (lock2.tryLock(5, TimeUnit.SECONDS)) {
                        System.out.println("lock2 also acquired by " + Thread.currentThread().getName());
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class OddOrEven implements Runnable {
        private final int num;
        private final boolean isOdd;
        private final Lock lock;

        public OddOrEven(int num, boolean isOdd, Lock lock) {
            this.num = num;
            this.isOdd = isOdd;
            this.lock = lock;
        }

        @Override
        public void run() {
            int temp = 0;
            while (temp <= num) {
                if (lock.tryLock()) {
                    if (isOdd && temp % 2 != 0) {
                        System.out.println(temp + " " + Thread.currentThread().getName());
                    }
                    if (!isOdd && temp % 2 == 0) {
                        System.out.println(temp + " " + Thread.currentThread().getName());
                    }
                    lock.unlock();
                    temp++;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*DeadLock deadLock = new DeadLockSolution1();

        Thread thread1 = new Thread(deadLock::method1);
        Thread thread2 = new Thread(deadLock::method2);

        thread1.start();
        thread2.start();

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long ids[] = bean.findMonitorDeadlockedThreads();

        if (ids != null) {
            ThreadInfo threadInfo[] = bean.getThreadInfo(ids);

            for (ThreadInfo threadInfo1 : threadInfo) {
                System.out.println(threadInfo1.getThreadId());    //Prints the ID of deadlocked thread

                System.out.println(threadInfo1.getThreadName());  //Prints the name of deadlocked thread

                System.out.println(threadInfo1.getLockName());    //Prints the string representation of an object for which thread has entered into deadlock.

                System.out.println(threadInfo1.getLockOwnerId());  //Prints the ID of thread which currently owns the object lock

                System.out.println(threadInfo1.getLockOwnerName());  //Prints name of the thread which currently owns the object lock.
            }
        } else {
            System.out.println("No Deadlocked Threads");
        }*/

        ReentrantLock lock = new ReentrantLock();
        Thread odd = new Thread(new OddOrEven(10, true, lock));
        Thread even = new Thread(new OddOrEven(10, false, lock));
        odd.start();
        even.start();
    }
}
