package com.collections.map;

import java.util.EnumMap;

public class EnumMapDemo {

    public enum Days {
        Sunday,
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday
    }
    public static void main(String[] args) {

        EnumMap<Days,String> enumMap = new EnumMap<>(Days.class);

        enumMap.put(Days.Sunday, "Holiday");
        enumMap.put(Days.Saturday, "HalfWorking Day");

        System.out.println(enumMap);
     }
}
