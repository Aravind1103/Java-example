package com.dp.singleton;

public class SingletonLazy {

    private static SingletonLazy obj = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (obj == null) {
            synchronized (obj) {
                if (obj == null) {
                    obj = new SingletonLazy();
                }
            }
        }
        return obj;
    }

}
