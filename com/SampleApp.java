import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

class DirectExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    }
}

class ThreadPerTaskExecutor implements Executor {    public void execute(Runnable r) {      new Thread(r).start();    }  }
public class SampleApp {
    public static int count = 0;

    static class  Task implements Runnable {

        @Override
        public void run() {
            count = count + 1;
            System.out.println("Added");
        }
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println("Task1 execution started at :" + (start - appStart));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count = count - 1;
            long end = System.currentTimeMillis();
            System.out.println("Task1 execution took :"+(end-start));
            System.out.println("Task1 execution ended at :" + (end - appStart));
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println("Task2 execution started at :" + (start - appStart));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count = count - 1;
            long end = System.currentTimeMillis();
            System.out.println("Task2 execution took :"+(end-start));
            System.out.println("Task2 execution ended at :" + (end - appStart));
        }
    }
    public static long appStart;

    public static void main(String[] args) throws InterruptedException {
        /*Executor executor = new ThreadPerTaskExecutor();

        executor.execute(new Task1());
        executor.execute(new Task());
        executor.execute(new Task1());
        executor.execute(new Task());*/

        /*
        ExecutorService executor1 = Executors.newFixedThreadPool(2);

        long statTime = System.currentTimeMillis();
        for(Runnable runnable: List.of(new Task(),new Task1(),new Task1(),new Task())) {
            executor1.submit(runnable);
        }

        System.out.println(count);
        executor1.shutdown();
        if(executor1.awaitTermination(5, TimeUnit.SECONDS)){
            long end = System.currentTimeMillis();
            System.out.println(end-statTime);
        }*/

        System.out.println("App Started");
        ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor();

        appStart = System.currentTimeMillis();
        executor2.scheduleWithFixedDelay(new Task1(),1,2,TimeUnit.SECONDS);
        executor2.scheduleWithFixedDelay(new Task2(),1,2,TimeUnit.SECONDS);

        //executor2.scheduleAtFixedRate(new Task1(),0,2,TimeUnit.SECONDS);

        Integer integer = Integer.valueOf("1210");


    }
}
