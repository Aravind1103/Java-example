package com.dp.singleton;

public class SingletonEager {
    private static final SingletonEager OBJ = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return OBJ;
    }
}
