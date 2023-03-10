/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class BeautifulString {

    public static void main(String[] args) {
        try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
            //try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            int k = 1;//Integer.parseInt(br.readLine());
            String s = "abazaaa";//br.readLine();

            System.out.println(calc(k, s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calc(int k, String s) {

        if ((s.length() - k) < 2) {
            return s.length();
        }

        int repeat = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.println(c);
            
            int first = 0;
            int second = 0;
            int replacements = k;

            for (int i = 0; i < s.length(); i++) {
                System.out.println("\ti=" + i);
                while (replacements >= 0) {
                    if (second >= s.length()) {
                        second++;
                        break;
                    }
                    if (c != s.charAt(second)) {
                        replacements--;
                    }
                    second++;
                }
                
                if (s.charAt(first++) != c) {
                    replacements++;
                }
                repeat = second - first > repeat ? second - first : repeat;
            }

        }

        return repeat;

    }
}
