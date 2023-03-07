/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.b;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class CorrectBraceSeq {

    public static void main(String[] args) {

        String input = "";
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        
        System.out.println(checkIfCorrect(input));

    }

    public static String checkIfCorrect(String input) {

        String result = "no";

        Map<Character, Integer> data = new HashMap<>();
        data.put('(', 10);
        data.put(')', 15);

        data.put('{', 20);
        data.put('}', 25);

        data.put('[', 30);
        data.put(']', 35);

        Stack<Character> s = new Stack();
        boolean isOk = true;

        if (!input.isEmpty() || !input.isBlank()) {

            for (int i = 0; i < input.length(); i++) {
                
                char c = input.charAt(i);
                
                if (data.containsKey(c)) {
                    int type = data.get(c);

                    if (type % 2 == 0) {
                        s.push(c);
                    } else {
                        if (s.isEmpty()) {
                            isOk = false;
                            break;
                        } else {
                            if (data.get(s.peek()) / 10 == type / 10) {
                                s.pop();
                            } else {
                                isOk = false;
                                break;
                            }
                        }
                    }
                }
                
            }
            
        }

        if (s.isEmpty() && isOk) {
            result = "yes";
        }
        System.out.println(s.toString());

        return result;

    }

}
