package com.example.demo;

import java.util.Arrays;

public class QuickSort {


    public int partition(int[] arr, int start, int end) {
        int pivot  = arr[end];
        int pIndex = start;
        for(int i=start;i<end;i++) {
            if(arr[i] <= pivot) {
                swap(arr,i,pIndex);
                pIndex++;
            }
        }
        swap(arr,pIndex,end);
        return pIndex;
    }

    public void swap (int[] array, int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }

        int pIndex = partition(arr,start,end);
        quickSort(arr, start, pIndex-1);
        quickSort(arr, pIndex+1, end);
    }


    public static void main(String[] args) {
        int[] arr = { 1,4,1,6,8,5,3,7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
