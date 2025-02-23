package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibo {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        Stream.iterate(res.get(0), r -> r + res.get(res.size()-1))
                .limit(5);

        System.out.println(res);
    }
}
