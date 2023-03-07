/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.a;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Gistograma {

    public static void main(String[] args) {
        
//        String s = "Twas brillig, and the slithy toves\n" +
//"Did gyre and gimble in the wabe;\n" +
//"All mimsy were the borogoves,\n" +
//"And the mome raths outgrabe.";
        
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
        }
        
        String s = sb.toString();

        Map<Character, Integer> map = new TreeMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = 1;
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (map.containsKey(c)) {
                value = map.get(c) + 1;
            }

            map.put(c, value);
            max = value > max ? value : max;
        }

        
        sb = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (i == 0) {
                    sb.append(key);
                    continue;
                }
                if (value >= i) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());

        
    }
}
