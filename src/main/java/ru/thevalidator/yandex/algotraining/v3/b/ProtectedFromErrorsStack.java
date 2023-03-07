/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.b;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class ProtectedFromErrorsStack {
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("bye");
                break;
            } else if (input.startsWith("push")) {
                Integer number = Integer.valueOf(input.substring(5).trim());
                stack.add(number);
                System.out.println("ok");
            } else if (input.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (input.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (input.equals("size")) {
                System.out.println(stack.size());
            } else if (input.equals("clear")) {
                stack.clear();
                System.out.println("ok");
            }
        }
    }

}
