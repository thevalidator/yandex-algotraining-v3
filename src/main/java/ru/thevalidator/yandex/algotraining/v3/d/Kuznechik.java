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
public class Kuznechik {

    public static void main(String[] args) throws IOException {
        String[] data = null;

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//            data = br.readLine().split(" ");
//        } catch (Exception e) {
//        }
        int n = 30;//Integer.parseInt(data[0]);
        int k = 1;//Integer.parseInt(data[1]);

        if (n < 3 || k == 1) {
            System.out.println(1);
        } else {
            if (k > n) {
                k = n;
            }
            int[] array = new int[n + 1];
            array[1] = 1;
            array[2] = 1;

            for (int i = 3; i <= k; i++) {
                array[i] = 2 * array[i - 1];
            }
            for (int i = k + 1; i <= n; i++) {
                array[i] = 2 * array[i - 1] - array[i - k - 1];
            }

            System.out.println(array[n]);
        }

    }
}
