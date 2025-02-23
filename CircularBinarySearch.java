package com.example.demo;

public class CircularBinarySearch {


    public int findNoOfRotation(int[] arr, int n){
        int start =  0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[start] <= arr[end]) {
                return start;
            }
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[prev] >= arr[mid] && arr[mid] <= arr[next]) {
                return mid;
            }
            if(arr[mid] <= arr[end]) {
                end = mid -1;
            }
            if(arr[mid] >= arr[start]){
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchInCircularArray(int[] arr, int n,int x){
        int start =  0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] <= arr[end]) {
                if (arr[mid] < x && arr[end] >= x){
                    start = mid + 1;
                }
                else{
                    end = mid -1;
                }
            }
            else{
                if (arr[start] <= x && arr[mid] > x){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,1,4,5};
        CircularBinarySearch circularBinarySearch = new CircularBinarySearch();
        System.out.println(circularBinarySearch.findNoOfRotation(arr,arr.length));
        System.out.println(circularBinarySearch.binarySearchInCircularArray(arr,arr.length,4));
    }
}
