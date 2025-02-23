package com.collections.set;

import com.collections.map.EnumMapDemo.*;

import java.util.Collections;
import java.util.EnumSet;

public class EnumSetDemo {

    public static void main(String[] args) {

        EnumSet<Days> enumSet1 = EnumSet.allOf(Days.class);
        EnumSet<Days> enumSet2 = EnumSet.noneOf(Days.class);
        EnumSet<Days> enumSet3 = EnumSet.of(Days.Sunday);

        EnumSet<Days> enumSet4 = EnumSet.complementOf(enumSet3);
        EnumSet<Days> enumSet5 = EnumSet.range(Days.Monday,Days.Friday);

        int number = 5;

        // 2 bit left shift operation
        int Ans = number >> 2;

        System.out.println(Ans);

    }
}
