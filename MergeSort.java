package com.example.demo;

import java.util.Arrays;

public class MergeSort {

    public  void merge(int[] left, int[] right, int[] arr){
        int i=0,j=0,k=0;
        int leftLength  = left.length,rightLength  = right.length;
        while (i< leftLength && j < rightLength){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;

            }
            k++;
        }

        while(i < leftLength){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < rightLength){
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for(int i=0; i< mid; i++) {
            left[i] = arr[i];
        }
        for(int i=mid; i< n; i++) {
            right[i-mid] = arr[i];
        }
        mergeSort(left,mid);
        mergeSort(right,n - mid);
        merge(left,right,arr);
    }


    public static void main(String[] args) {
        int[] arr = { 5, 1, 6, 2, 3, 4 };
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
