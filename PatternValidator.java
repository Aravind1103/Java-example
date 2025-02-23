package com.example.demo;

public class PatternValidator {

    public static void main(String[] args) {
        String input = "{({}{}[)]";
        StringBuilder res= new StringBuilder();
        for(int i=0;i<input.length();i++){
            char temp = input.charAt(i);
            if(temp == '{')
                res.append('}');
            if(temp == '[')
                res.append(']');
            if(temp == '(')
                res.append(')');
            if(temp == '<')
                res.append('>');
            if(temp == '}'){
                if(res.charAt(res.length()-1) == temp){
                    res.deleteCharAt(res.length()-1);
                }
                else {
                    break;
                }
            }
            if(temp == ']'){
                if(res.charAt(res.length()-1) == temp){
                    res.deleteCharAt(res.length()-1);
                }
                else {
                    break;
                }
            }
            if(temp == ')'){
                if(res.charAt(res.length()-1) == temp){
                    res.deleteCharAt(res.length()-1);
                }
                else {
                    break;
                }
            }
            if(temp == '>'){
                if(res.charAt(res.length()-1) == temp){
                    res.deleteCharAt(res.length()-1);
                }
                else {
                    break;
                }
            }
        }

        if(!res.toString().equals("")){
            System.out.println("False");
        }
        else {
            System.out.println("True");
        }
    }
}
