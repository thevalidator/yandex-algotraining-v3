/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Nails {

    public static void main(String[] args) {

        int n;
        String[] data = null;

//        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//            n = Integer.parseInt(br.readLine());
//            data = br.readLine().split(" ");
//        } catch (Exception e) {
//        }

        n = 6;
        data = "0 10000".split(" ");//"682 2478 2517 2816 4980 5839 6414 7667 8802 8995".split(" ");
        
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : data) {
            list.add(Integer.valueOf(s));
        }
        Collections.sort(list);
        
        int result = calc(list);
        System.out.println("> " + result);
    }

    private static int calc(ArrayList<Integer> list) {
        
        int dp[] = new int[list.size()];
        dp[1] = list.get(1) - list.get(0);
        
        
        if (list.size() == 2) {
            return dp[1];
        }
        dp[2] = dp[1] + list.get(2) - list.get(1);
        if (list.size() == 3) {
            return dp[2];
        }

        int i = 3;
        while (i < list.size()) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + list.get(i) - list.get(i - 1);
            i++;
        }
        
        return dp[dp.length - 1];
    }
}
