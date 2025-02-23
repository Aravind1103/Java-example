package com.collections.map;

import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        TreeMap<Integer,String> treeMap = new TreeMap<>();

        treeMap.put(1,"Aravind");
        treeMap.put(2,"Arun");
        treeMap.put(3,"Raj");
        treeMap.put(4,"Amar");

        treeMap.floorEntry(5);
        treeMap.ceilingEntry(0);

        treeMap.headMap(3);
        treeMap.tailMap(3);

        treeMap.descendingMap();
        treeMap.descendingKeySet();

        System.out.println(treeMap);
    }
}
