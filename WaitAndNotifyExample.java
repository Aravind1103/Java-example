import java.util.concurrent.locks.Lock;
import java.util.function.Predicate;

public class WaitAndNotifyExample {

    public final static Object object = new Object();

    public static class OddOrEven implements Runnable {
        private final int num;
        private final boolean isOdd;
        private final Object lock;
        private static int temp = 1;  // Shared between both threads

        public OddOrEven(int num, boolean isOdd, Object lock) {
            this.num = num;
            this.isOdd = isOdd;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (temp <= num) {
                synchronized (lock) {
                    // Check if it's the turn of the current thread (odd or even)
                    if (isOdd && temp % 2 == 1 || !isOdd && temp % 2 == 0) {
                        System.out.println(temp + " " + Thread.currentThread().getName());
                        temp++;  // Increment the shared temp variable

                        // Notify the other thread to take over
                        lock.notify();
                    } else {
                        try {
                            // Wait for the other thread to notify when it's done
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

/*        Thread even = new Thread(new Printer(10), "even");
        Thread odd = new Thread(new Printer(10), "odd");

        even.start();
        odd.start();

        Thread.sleep(2000);

        System.out.println("Done");*/

        Object obj = new Object();
        Thread thread1 = new Thread(new OddOrEven(10, true, obj));
        Thread thread2 = new Thread(new OddOrEven(10, false, obj));

        thread1.start();
        thread2.start();
    }


    public static class Printer implements Runnable {
        private final int n;

        public Printer(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Started");
            int temp = 0;
            while (temp <= n) {
                if (temp % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                    System.out.println(Thread.currentThread().getName() + "Next Iteration");
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + " " + temp);
                        System.out.println(Thread.currentThread().getName() + " calling notify");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    if (temp % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                        System.out.println(Thread.currentThread().getName() + "Next Iteration");
                        synchronized (object) {
                            System.out.println(Thread.currentThread().getName() + " " + temp);
                            System.out.println(Thread.currentThread().getName() + " calling wait");
                            object.notify();
                        }
                    }
                }
                temp++;
            }
        }
    }
}
