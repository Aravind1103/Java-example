package com.example.demo.dp;

public class MinFallingPath  {

    public static int minFallingPathSum(int[][] matrix) {

        for(int i=matrix.length-2;i>=0;i--) {
            for(int j=0;j<matrix.length;j++){
                int min = matrix[i+1][j];
                if(j == 0 && j < matrix.length - 1){
                    min = Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if (j == matrix.length - 1) {
                    min = Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else {
                    min = Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                    min = Math.min(min,matrix[i+1][j-1]);
                }
                matrix[i][j] =  matrix[i][j] + min;
            }
        }

        int res = matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            if(res > matrix[0][i])
                res = matrix[0][i];
        }

        return res;
    }

    public static int minFallingPathSum1(int[][] matrix) {

        for(int i=matrix.length-2;i>=0;i--) {
            for(int j=0;j<matrix.length;j++){
                int min = matrix[i+1][j];
                if(j == 0 && j < matrix.length - 1){
                    min = matrix[i+1][j+1];
                }
                else if (j == matrix.length - 1) {
                    min = matrix[i+1][j-1];
                }
                else {
                    min = Math.min(matrix[i+1][j+1],matrix[i+1][j-1]);
                }
                matrix[i][j] =  matrix[i][j] + min;
            }
        }

        int res = matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            if(res > matrix[0][i])
                res = matrix[0][i];
        }

        return res;
    }

    public static void main(String[] args) {
        //System.out.println(minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        System.out.println(minFallingPathSum1(new int[][]{{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}}));
    }
}
