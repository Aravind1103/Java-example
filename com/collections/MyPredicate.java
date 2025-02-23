package com.collections;

import java.util.function.Predicate;

public class MyPredicate implements Predicate<Emp> {
    @Override
    public boolean test(Emp o) {
        return false;
    }

    public static Predicate<Emp> myAnd(Predicate<Emp> predicate1, Predicate<Emp> predicate2){
        return (t) -> predicate1.test(t) && predicate2.test(t);
    }

}
