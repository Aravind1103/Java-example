package com.collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;





public class Java8Feature {



/*    public static class User {
        public User(int id, String name, List<String> emails) {
            this.id = id;
            this.name = name;
            this.emails = emails;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<String> getEmails() {
            return emails;
        }

        public double getMark() {
            return mark;
        }

        public User(int id, String name, List<String> emails, double mark) {
            this.id = id;
            this.name = name;
            this.emails = emails;
            this.mark = mark;
        }

        private int id;
        private String name;
        private List<String> emails;
        private double mark;

    }
    public static void main(String[] args) {

        Stream<User> userList = Stream.of(new User(4,"Aravind",List.of("email1","email2")),
                new User(1,"Aravind",List.of("email8","email8")),
                new User(5,"Arun",List.of("email3","email4")),
                new User(2,"Dhoni",List.of("email6","email5")));
        userList.sorted(Comparator.comparing(User::getId)).map(User::getName).forEach(System.out::println);

        Stream<User> userList1 = Stream.of(new User(4,"Aravind",List.of("email1","email2"),95),
                new User(1,"Aravind",List.of("email8","email8"),92),
                new User(5,"Arun",List.of("email3","email4"),90),
                new User(2,"Dhoni",List.of("email6","email5"),95));

        Map<Double,List<User>> a = userList1.collect(Collectors.groupingBy(User::getMark));
        Map<Double,Set<User>> b = userList1.collect(Collectors.groupingBy(User::getMark,Collectors.toSet()));
        Map<Double,Map<String, List<User>>> c = userList1.collect(Collectors
                .groupingBy(User::getMark,Collectors.groupingBy(User::getName)));


        Map<Double, Optional<User>> res = userList1.collect(Collectors.groupingBy(User::getMark,
                Collectors.maxBy(Comparator.comparingDouble(User::getMark))));

        Map<Double, User> res1 = userList1.collect(Collectors.toMap(User::getMark, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingDouble(User::getMark))));

        Map<Double, User> res2 = userList1.collect(Collectors.toMap(User::getMark, Function.identity(),
                (u1,u2)-> u1.getMark() > u2.getMark() ? u1 : u2));

        List<User> second = userList1.sorted(Comparator.comparingDouble(User::getMark))
                .skip(1).limit(1).collect(Collectors.toList());

        List<User> secondLast = userList1.sorted(Comparator.comparingDouble(User::getMark).reversed())
                .skip(1).limit(1).collect(Collectors.toList());


        TestInterface.hello();

        Predicate<Emp> predicate = emp -> emp.getName() != null;

        Predicate<Emp> temp = MyPredicate.myAnd(MyPredicate.myAnd(predicate,predicate),predicate);
    }*/
}
