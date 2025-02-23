package com.example.demo.dp;

import java.util.*;

public class LIS {

    public static int lis(int[] arr){
        int ans = 1;
        int[] lis = new int[arr.length];
        int[] sum = new int[arr.length];
        Map<Integer,List<Integer>> res = new HashMap();


        for(int i=0;i<arr.length;i++){
            lis[i] = 1;
            sum[i]  = arr[i];
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            res.put(i,list);
        }

        for(int i=1;i< arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                    sum[i] = Math.max(sum[i],sum[j] + arr[i]);
                    if(res.get(i).size() < res.get(j).size() + 1){
                       res.put(i,new ArrayList<>());
                       res.get(i).addAll(res.get(j));
                       res.get(i).add(arr[i]);
                    }
                }
            }
        }
        for (int li : lis)
            if (li > ans)
                ans = li;

        return ans;
    }

    public static void main(String[] args){
        int[] arr = {10,5,7,11,16,15};
        System.out.println(lis(arr));
    }
}
