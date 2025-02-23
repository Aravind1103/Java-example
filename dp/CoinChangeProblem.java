package com.example.demo.dp;

public class CoinChangeProblem {


    public static int ans(int[] arr, int sum){
        int[][] res = new int[arr.length][sum+1];

        for(int i=0;i<arr.length;i++){
            res[i][0] = 1;
        }

        for(int j=0;j<=sum;j++){
            if(j%arr[0] == 0)
                res[0][j] = 1;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i] > j)
                    res[i][j] = res[i-1][j];
                else{
                    res[i][j] = res[i-1][j] + res[i][j-arr[i]];
                }
            }
        }
        return res[arr.length-1][sum];
    }

    public static void main(String[] args) {
        System.out.println(CoinChangeProblem.ans(new int[]{2, 3, 5, 7},7));
    }
}
