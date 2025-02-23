package com.dp.singleton;

public class SingletonUsingInnerClass {

    private static SingletonUsingInnerClass obj = null;

    private SingletonUsingInnerClass() {
    }

    private static class SingleHelper {
        private static SingletonUsingInnerClass OBJ = new SingletonUsingInnerClass();
    }

    public static SingletonUsingInnerClass getInstance() {
        return SingleHelper.OBJ;
    }
}
