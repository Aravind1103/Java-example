package com.example.demo;

import java.util.Scanner;

public class BfPattern {

    public static void printButterfly(int n) {
        int stars = n/2 + 1;
        int spaces = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=stars;j++)
                System.out.print("*");
            for(int j=1;j<=spaces;j++)
                System.out.print(" ");
            for(int j=1;j<=stars;j++)
                System.out.print("*");
            System.out.println();

            if(i < n/2 + 1) {
                spaces = spaces + 2;
                stars = stars - 1;
            }
            else {
                spaces = spaces - 2;
                stars = stars + 1;
            }
        }
    }

    public static void printRompus(int n) {
        int stars = n;
        int spaces = n-1;
        int spaces1 = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            for(int j=1;j<=spaces1;j++){
                System.out.print(" ");
            }
            System.out.println();
            spaces1++;
            spaces--;
        }
    }
    public static void diamond(int n) {
        int star1 = n/2;
        int star2 = n/2;
        for (int j=1;j<=n;j++){
            for(int i=0;i<n;i++){
                if(star2 == star1 && i == star1) {
                    System.out.print("*");
                }
                else if(star2 == i || star1 == i){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(j < n/2 + 1){
                star2++;
                star1--;
            }
            else {
                star2--;
                star1++;
            }
        }
    }

    public static void main(String[] args){
        diamond(9);
    }
}
