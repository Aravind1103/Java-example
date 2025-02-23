package com.collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

    public static void main(String[] args) {

        String str = "aadsdsadsdf";

        var res = IntStream.range(0,str.length()).boxed().collect(Collectors.groupingBy(str::charAt, Collectors.counting()));

        List<CollectorsDemo.Person> people = Arrays.asList(
                new CollectorsDemo.Person("Alice", 28, CollectorsDemo.Gender.FEMALE),
                new CollectorsDemo.Person("Bob", 32, CollectorsDemo.Gender.MALE),
                new CollectorsDemo.Person("Charlie", 22, CollectorsDemo.Gender.MALE),
                new CollectorsDemo.Person("David", 27, CollectorsDemo.Gender.MALE),
                new CollectorsDemo.Person("Eve", 35, CollectorsDemo.Gender.FEMALE),
                new CollectorsDemo.Person("Frank", 19, CollectorsDemo.Gender.MALE)
        );

        var eldestPerson = people.stream().max(Comparator.comparingInt(CollectorsDemo.Person::getAge));
        var youngestPerson = people.stream().min(Comparator.comparingInt(CollectorsDemo.Person::getAge));

        var secondEldestPerson = people.stream().sorted(Comparator.comparingInt(CollectorsDemo.Person::getAge).reversed())
                .skip(1).limit(1).findFirst();

        var eledestPersonbyGender = people.stream().collect(Collectors.groupingBy(CollectorsDemo.Person::getGender,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(CollectorsDemo.Person::getAge)))));

        var eledestPersonNamebyGender = people.stream().collect(Collectors.groupingBy(CollectorsDemo.Person::getGender,
                Collectors.collectingAndThen(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(CollectorsDemo.Person::getAge))), p -> p.get().getName())));

        var  votersMap = people.stream()
                .collect(Collectors.partitioningBy( p -> p.getAge() >= 18,
                        Collectors.groupingBy(CollectorsDemo.Person::getGender,Collectors.mapping(CollectorsDemo.Person::getName,Collectors.toList()))));

        var  eldestvotersByGender = people.stream()
                .collect(Collectors.partitioningBy( p -> p.getAge() >= 18,
                        Collectors.groupingBy(CollectorsDemo.Person::getGender,
                                Collectors.collectingAndThen(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(CollectorsDemo.Person::getAge))),p -> p.get().getAge()))));
    }
}
