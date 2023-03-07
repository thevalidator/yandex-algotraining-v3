/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class BeautifulString {

    public static void main(String[] args) throws IOException {
        int max = 0;
        int k = 2;
        String s = "helto";//"ababababababababababababababababababababababababababababababababababababababababababababababababababbcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        //"helto";//"aaaiaaiiaa";//"acvvvvkjvvvvuuiiiiiii";//abcaaaaaaz";//"heltoe";
        //System.out.println(k + " " + s);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int k = Integer.parseInt(br.readLine());
        //String s = br.readLine();
//        while ((line = br.readLine()) != null) {
//            if (line.charAt(0) == '0') {
//                int number = Integer.parseInt(line.substring(2));
//                heap.insert(number);
//            } else {
//                System.out.println(heap.extract());
//            }
//        }
        System.out.println(s);
        int replacements = k;
        int right = 0;
        System.out.println("rep:" + k);
        
        for (int left = 0; left < s.length(); left++) {

            System.out.println("left:" + left);
            if (left > 0 && (int) s.charAt(left) != 't') {
                replacements++;
            }
            //System.out.println("rep:" + replacements);
            
            while (replacements >= 0 && right < s.length()) {
                if (s.charAt(right) != 't') {
                    replacements--;
                } 
                right++;
            }
            
            
            System.out.println("max:" + (right - left) + " r:" + (right) + " l:" + left);

        }

    }
}
