package com.example.demo.dp;

public class CommonSubSequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] res = new int [text1.length() + 1][text2.length() + 1];

        for(int i=0;i<res.length;i++)
            res[i][0] = 0;

        for(int i=0;i<res[0].length;i++)
            res[0][i] = 0;

        for(int i= 1;i<res.length;i++){
            for(int j=1;j<res[i].length;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    res[i][j] = 1 + res[i-1][j-1];
                else
                    res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
        }
        }

        return res[text1.length()][text2.length()];
    }

    public static boolean isSubsequence(String s, String t) {
        boolean[][] res = new boolean[s.length()][t.length()];

        if(s.length() == 0){
            return true;
        }

        if(t.length() == 0){
            return false;
        }

        for(int i=0;i<t.length();i++){
            if(s.charAt(0) == t.charAt(i))
                res[0][i] = true;
            else if (i == 0)
                res[0][0] = false;
            else
                res[0][i] = res[0][i-1];
        }

        for(int i=1; i<s.length();i++){
            res[i][0] = false;
        }

        for(int i=1;i<s.length();i++){
            for(int j=1;j<t.length();j++){
                if(s.charAt(i) == t.charAt(j)){
                    res[i][j] = res[i-1][j-1];
                }
                else{
                    res[i][j] = res[i][j-1];
                }
            }
        }

        return res[s.length()-1][t.length()-1];
    }

    public static void main(String[] args){
        //System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(isSubsequence("b","c"));
    }

}
