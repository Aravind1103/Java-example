package com.example.demo;

public class BinarySearch {


    public int binarySearch(int[] arr, int x){
        int start =  0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == x) {
                return mid;
            }
            else if( arr[mid] > x) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int x,boolean flag){
        int start =  0;
        int end = arr.length-1;
        int result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == x) {
                result = mid;
                if (flag){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if( arr[mid] >  x) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 4, 5, 5,6};
        BinarySearch search = new BinarySearch();
        System.out.println("Simple search of 6: "+search.binarySearch(arr,6));
        System.out.println("First Occurrence of 5: "+search.binarySearch(arr,5,true));
        System.out.println("Last Occurrence of 5: "+search.binarySearch(arr,5,false));
        System.out.println("No of Occurrences of 4: " + (search.binarySearch(arr,4,false) - search.binarySearch(arr,4,true) + 1));
    }
}
