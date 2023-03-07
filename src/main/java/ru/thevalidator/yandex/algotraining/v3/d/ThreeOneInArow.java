/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class ThreeOneInArow {
    public static void main(String[] args) throws IOException {
        
        //int n = 9;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int arraySize = n > 3 ? n + 1 : 4;
        int[] array = new int[arraySize];
        array[0] = 0;
        array[1] = 2;
        array[2] = 4;
        array[3] = 7;
        for (int i = 4; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        
        System.out.println(">> " + array[n]);
    }
}
