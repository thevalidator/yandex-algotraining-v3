/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.b;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Postfix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        
        System.out.println(getResult(input));
        
    }
    
    public static int getResult(String input) {
        String[] array = input.split(" ");
        Stack<Integer> stack = new Stack();
        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        
        for (String element : array) {
            
            if (operators.contains(element)) {
                int b = stack.pop();
                int a = stack.pop();
                int tmp;
                tmp = switch (element) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    default -> a * b;
                };
                stack.push(tmp);
            } else {
                stack.push(Integer.valueOf(element));
            }
            
        }
        
        return stack.pop();
    }

}
