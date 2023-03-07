/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class BuyTickets {

    public static void main(String[] args) {

        int n;
        int[][] data;

        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            n = Integer.parseInt(br.readLine());
            data = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                data[i][0] = Integer.parseInt(line[0]);
                data[i][1] = Integer.parseInt(line[1]);
                data[i][2] = Integer.parseInt(line[2]);
            }
            int result = calc(n, data);
            System.out.println(result);
        } catch (Exception e) {
        }

    }

    private static int calc(int n, int[][] data) {

        if (n <= 3) {
            if (n == 1) {
                return data[0][0];
            }
            int min2 = Math.min(data[1][0] + data[0][0], data[0][1]);
            if (n == 2) {
                return min2;
            }
            if (n == 3) {
                return Math.min(Math.min(data[2][0] + min2, data[1][1] + data[0][0]), data[0][2]);
            }
        }

        int[] minPrice = new int[n];

        minPrice[0] = data[0][0];

        minPrice[1] = Math.min(data[1][0] + minPrice[0], data[0][1]);

        minPrice[2] = Math.min(Math.min(data[2][0] + minPrice[1], data[1][1] + minPrice[0]), data[0][2]);

        for (int i = 3; i < n; i++) {
            minPrice[i] = Math.min(
                    Math.min(data[i][0] + minPrice[i - 1], data[i - 1][1] + minPrice[i - 2])
                    , data[i - 2][2] + minPrice[i - 3]
            );
        }
        
        return minPrice[n - 1];
    }
}
