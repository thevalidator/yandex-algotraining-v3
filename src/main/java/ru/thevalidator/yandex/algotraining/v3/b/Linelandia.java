/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Linelandia {
    
    public static void main(String[] args) {
        
        int n;
        String[] data = null;
        
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            n = Integer.parseInt(br.readLine());
            data = br.readLine().split(" ");

            System.out.println(calc(data));

        } catch (Exception e) {
        }
        
    }
    
    private static String calc(String[] data) {
        Stack<Integer[]> s = new Stack();
        int[] indexes = new int[data.length];
        
        for (int i = 0; i < data.length; i++) {
            int x = Integer.parseInt(data[i]);
            
            while (!s.isEmpty() && s.peek()[0] > x) {
                Integer[] city = s.pop();
                indexes[city[1]] = i;
            }
            s.push(new Integer[]{x, i});
        }
        
        while (!s.isEmpty()) {
            Integer[] city = s.pop();
            indexes[city[1]] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int index : indexes) {
            sb.append(index).append(" ");
        }
        sb.setLength(sb.length() - 1);
        
        return sb.toString();
    }
}
