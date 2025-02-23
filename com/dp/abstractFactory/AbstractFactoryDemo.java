package com.dp.abstractFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbstractFactoryDemo {


    public static void main(String[] args) {

        String message = "This is test String";
        var res = message.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(res);
    }
}
