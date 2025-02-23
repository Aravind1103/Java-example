package com.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply((f) -> f.concat("World!"))
                .thenCompose((f) -> CompletableFuture.supplyAsync(() -> f.concat("end")));


        CompletableFuture<String> future1 = future.thenCombine(CompletableFuture.supplyAsync(() -> "thenCombine"),(f1,f2) -> f1 + f2);

        future.thenAcceptBoth(CompletableFuture.supplyAsync(() -> "thenAcceptBoth"),(f1,f2) -> System.out.println(f1 + f2));

        future.acceptEither(CompletableFuture.supplyAsync(() -> "acceptEither"), System.out::println);

        CompletableFuture<String> future2 =  future.applyToEither(CompletableFuture.supplyAsync(() -> "applyToEither"),f1 -> f1.concat("Applied"));

        CompletableFuture<String> exFuture = CompletableFuture.supplyAsync( () -> {
           throw new RuntimeException("TEst");
        });

        var exFuture0 = future.exceptionally( ex -> {
            System.out.println(ex.getMessage());
            return "exceptionally";
        });

        var exFuture1 = exFuture.exceptionally( ex -> {
            System.out.println(ex.getMessage());
            return "exceptionally";
        }
        );

        var exFuture2 = exFuture1.handle( (res, ex) -> {
            if(ex == null){
                return res;
            }
            else {
                System.out.println(ex.getMessage());
                return "handle";
            }
        });

        var exFuture3 = exFuture.handle( (res, ex) -> {
            if(ex == null){
                System.out.println(res);
            }
            else {
                System.out.println(ex.getMessage());
                return "handle";
            }
            return res;
        });



    }
}
