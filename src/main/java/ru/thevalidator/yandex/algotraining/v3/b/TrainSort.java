/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.b;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class TrainSort {
    
    public static void main(String[] args) {
        
        //int[] array = {2, 3, 1};//{4, 1, 3, 2};
        
        Scanner scanner = new Scanner(System.in);
        int counter = -1;
        int n = 0;
        String[] array = null;

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("-")) {
                break;
            }
            if (counter == -1) {
                //n = Integer.parseInt(input);
                //array = new int[n];
                counter++;
            } else {
                array = input.split(" ");
            }
            counter++;
        }
        
        System.out.println(chechIfCanSort(array));
        
    }
    
    public static String chechIfCanSort(String[] array) {
        String result = "NO";
        
        Stack<Integer> s = new Stack<>();
        
        int target = 1;
        
        for (String el : array) {
            int actual = Integer.parseInt(el);
            if (actual != target) {
                if (!s.isEmpty() && s.peek() < actual ) {
                    break;
                } else {
                    s.push(actual);
                }
            } else {
                target++;
                while (!s.isEmpty() && s.peek() == target) {
                    s.pop();
                    target++;
                }
            }
        }
        
        if (s.isEmpty()) {
            result = "YES";
        }
        
        
        return result;
    }

}
