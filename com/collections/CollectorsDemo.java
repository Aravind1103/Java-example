package com.collections;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CollectorsDemo {


    public static void main(String[] args) {



        Map<Character, Long> charCountMap = "adafdfdwewff".chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        charCountMap.forEach((k,v) -> {
            System.out.println(k + " " + v);
        });


        List<Person> people = Arrays.asList(
                new Person("Alice", 28, Gender.FEMALE),
                new Person("Bob", 32, Gender.MALE),
                new Person("Charlie", 22, Gender.MALE),
                new Person("David", 27, Gender.MALE),
                new Person("Eve", 35, Gender.FEMALE),
                new Person("Frank", 19, Gender.MALE)
        );

        Person secondEldestPerson =  people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .skip(1)
                .limit(1).findFirst().orElse(null);

        Person eldestPerson =  people.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);

        var eldestPersonByGender =  people.stream()
                .collect(Collectors.groupingBy(Person::getGender,Collectors
                                .reducing(BinaryOperator.maxBy(Comparator.comparingInt(Person::getAge)))));

        Map<Gender,String> eldestPersonNamesByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender,Collectors
                        .collectingAndThen(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(Person::getAge))),p -> p.get().getName())));

        List<Person> top5eldest =  people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .limit(5).collect(Collectors.toList());

        List<Person> sortPersonsByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        List<Person> sortPersonsByAgeReverse = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());

        List<Person> sortPersonsByAgeAndName = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge)
                        .thenComparing(Person::getName))
                .collect(Collectors.toList());

        Map<Gender,List<Person>> personsByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));

        Map<Gender,List<String>> personsNameByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));

        Map<Gender,Long> countByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender,Collectors.counting()));

        Map<Boolean,Map<Gender,Set<Person>>>  votersMap = people.stream()
                .collect(Collectors.partitioningBy( p -> p.age >= 18,Collectors.groupingBy(Person::getGender,Collectors.toSet())));

        Map<Boolean,Set<Person>>  votersSetMap = people.stream()
                .collect(Collectors.partitioningBy( p -> p.age >= 18,Collectors.toSet()));

        Map<Boolean,Set<Person>>  votersSetMap1 = people.stream()
                .collect(Collectors.partitioningBy( p -> p.age >= 18,Collectors.toCollection(()-> new TreeSet<>(Comparator.comparingInt(Person::getAge)))));

        Map<Gender,List<String>> namesByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender,Collectors.mapping(Person::getName,Collectors.toList())));

        Map<Gender, Set<Person>> personsByGender1 = people.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.toSet()));

        TreeMap<Gender, Set<Person>> personsByGender3 = people.stream()
                .collect(Collectors.groupingBy(Person::getGender,TreeMap::new,Collectors.toSet()));

        TreeMap<Gender, Set<String>> personsNameByGender3 = people.stream()
                .collect(Collectors.groupingBy(Person::getGender,TreeMap::new,Collectors.mapping(Person::getName,Collectors.toSet())));


        String delimitor = "|";
        BiConsumer<StringBuilder,CharSequence> accumulator = (sb ,element) -> {
            if(sb.length() > 0){
                sb.append(delimitor);
            }
            sb.append(element);
        };

        BinaryOperator<StringBuilder> combiner =  (sb1,sb2) -> {
            if(sb2.isEmpty()){
                return sb1;
            }
            if(sb1.isEmpty()){
                return sb2;
            }
            sb1.append(delimitor).append(sb2);
            return sb1;
        };

        Function<StringBuilder,String>  finisher = StringBuilder::toString;

        Collector<CharSequence, StringBuilder,String> temp = Collector.of(
                StringBuilder::new,
                accumulator,
                combiner,
                finisher
        );

        String result = people.stream().map(Person::getName).collect(temp);

        System.out.println(result);
    }

    static class Person {
        private String name;
        private int age;
        private Gender gender;

        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
