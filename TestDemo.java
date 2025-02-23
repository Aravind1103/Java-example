import java.util.Arrays;

public class TestDemo {

    public static class OddOrEven implements Runnable {
        private final int num;
        private final boolean isOdd;
        private final Object lock;

        public OddOrEven(int num, boolean isOdd, Object lock) {
            this.num = num;
            this.isOdd = isOdd;
            this.lock = lock;
        }

        @Override
        public void run() {
            int temp = 1;
            while (temp <= num) {
                if (isOdd && temp % 2 != 0) {
                    synchronized (lock) {
                        System.out.println("Lock acquired by " + Thread.currentThread().getName());
                        System.out.println(temp + " " + Thread.currentThread().getName());
                    }
                }
                if (!isOdd && temp % 2 == 0) {
                    synchronized (lock) {
                        System.out.println("Lock acquired by " + Thread.currentThread().getName());
                        System.out.println(temp + " " + Thread.currentThread().getName());
                    }
                    System.out.println("Lock released by " + Thread.currentThread().getName());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (isOdd) {
                    lock.notify();
                    System.out.println("Lock released by " + Thread.currentThread().getName());
                }
                temp++;
            }
        }
    }


    public static int[] rearrange(int[] arr) {
        int current;
        for (int i = 0; i < arr.length; i++) {
            current = arr[i];
            if (current > 0) {
                continue;
            }
            int j = i - 1;
            while (j >= 0 && arr[j] > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {

        /*List<Integer> arr = Arrays.asList(1,2,3,3,4,5,5);

        List<Integer> rs = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter((k -> k.getValue() > 1))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(rs);*/

        /*Object obj = new Object();
        Thread thread1 = new Thread(new OddOrEven(10, true, obj));
        Thread thread2 = new Thread(new OddOrEven(10, false, obj));

        thread1.start();
        thread2.start();*/

        int[] arr = {1,2,-3,-4};
        System.out.println(Arrays.toString(rearrange(arr)));
    }

}
