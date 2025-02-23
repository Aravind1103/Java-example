package com.example.demo.ds;

import java.util.Stack;

public class InfixToPostFix {

    public String infixToPostFix(String infix){
        StringBuilder postFix =  new StringBuilder();
        Stack<Character> s = new Stack<>();

        for(int i=0;i<infix.length();i++){
            Character ch = infix.charAt(i);
            if(isOperand(ch)){
                postFix.append(ch);
            }
            else if (isOperator(ch)){
                while(!s.empty() && PrecedenceOf(s.peek()) >= PrecedenceOf(ch)){
                    postFix.append(s.peek());
                    s.pop();
                }
                s.push(ch);
            }
            else if(ch == ')'){
                while (!s.empty() && s.peek() != '('){
                    postFix.append(s.peek());
                    s.pop();
                }
                s.pop();
            }
            else {
                s.push(ch);
            }
        }
        while(!s.empty()){
            postFix.append(s.pop());
        }

        return postFix.toString();
    }


    private boolean isOperator(Character ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '$';
    }

    private boolean isOperand(Character ch){
        if(ch >= '0' && ch <= '9') return true;
        if(ch >= 'a' && ch <= 'z') return true;
        return ch >= 'A' && ch <= 'Z';
    }

    static int PrecedenceOf(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPrefix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();
        for(int i= infix.length()-1;i>=0;i--){
            Character ch = infix.charAt(i);
            if(isOperand(ch)){
                prefix.append(ch);
            }
            else if(isOperator(ch)){
                while(!stack.empty() && PrecedenceOf(stack.peek()) >= PrecedenceOf(ch)){
                    prefix.append(stack.pop());
                }
                stack.push(ch);
            }
            else if (ch == '(') {
                while(!stack.empty() && stack.peek() != ')'){
                    prefix.append(stack.pop());
                }
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }

        while (!stack.empty()){
            prefix.append(stack.pop());
        }
        return prefix.reverse().toString();
    }

    public String prefixToInfix(String prefix) {
        Stack<String>stack = new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            Character ch = prefix.charAt(i);
            if(isOperator(ch)){
                String exp = "(" +stack.pop() + ch + stack.pop() + ")";
                stack.push(exp);
            }
            else{
                stack.push(String.valueOf(ch));
            }
        }
        return stack.peek();
    }

    public String postfixToInfix(String postfix) {
        Stack<String>stack = new Stack<>();
        for(int i=0;i<postfix.length();i++){
            Character ch = postfix.charAt(i);
            if(isOperator(ch)){
                String rOp  = stack.pop();
                String exp = "(" +stack.pop() + ch + rOp + ")";
                stack.push(exp);
            }
            else{
                stack.push(String.valueOf(ch));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args){
        InfixToPostFix infixToPostFix = new InfixToPostFix();

        System.out.println(infixToPostFix.infixToPostFix("a*(b+c)"));
        System.out.println(infixToPostFix.infixToPrefix("a*(b+c)"));
        System.out.println(infixToPostFix.prefixToInfix("*a+bc"));
        System.out.println(infixToPostFix.postfixToInfix("abc+*"));
    }

}
