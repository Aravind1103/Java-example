package com.dp.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<String> mobiles = new ArrayList<>();

    public void addMobile(String mobile){
        mobiles.add(mobile);
        System.out.println(mobile + "added to the store");
    }

    public void soldMobile(String mobile){
        mobiles.remove(mobile);
        System.out.println(mobile + "removed from the store");
    }
}
