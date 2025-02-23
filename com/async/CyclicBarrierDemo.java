package com.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CyclicBarrierDemo {

    public static class Worker implements Runnable {

        private final CyclicBarrier cyclicBarrier;
        private final List<String> output;

        public Worker(CyclicBarrier cyclicBarrier, List<String> output) {
            this.cyclicBarrier = cyclicBarrier;
            this.output = output;
        }

        @Override
        public void run() {
            output.add(Thread.currentThread().getName() + "Registered");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "Registered for round 2");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class AggregatorWorker implements Runnable {

        private final List<String> parties;

        public AggregatorWorker(List<String> parties) {
            this.parties = parties;
        }

        @Override
        public void run() {
           System.out.println("parties registered" + parties.size());
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, TimeoutException {

        List<String>  parties  = Collections.synchronizedList(new ArrayList<>());
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6,new AggregatorWorker(parties));

        List<Thread> threads = Stream.generate(() -> new Thread(new Worker(cyclicBarrier,parties)))
                .limit(5).collect(Collectors.toList());

        threads.forEach(Thread::start);
        cyclicBarrier.await();
        parties.add("Round one done");
        cyclicBarrier.await();
        parties.add("Round two done");
        System.out.println(parties);
    }
}
