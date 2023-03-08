/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class HorseMove {

    public static void main(String[] args) {
        int n;
        int m;

        try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
            //try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            var limits = br.readLine().split(" ");
            n = Integer.parseInt(limits[0]);
            m = Integer.parseInt(limits[1]);

            System.out.println(calc(n - 1, m - 1));
            System.out.println(calc2(n, m));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int calc(int n, int m) {

        if (n == m && n == 0) {
            return 1;
        }

        if (n < 0 || m < 0) {
            return 0;
        }

        int n1 = n - 1;
        int m1 = m - 2;

        int n2 = n - 2;
        int m2 = m - 1;

        return calc(n1, m1) + calc(n2, m2);

    }

    public static int calc2(int n, int m) {

        if (n == m && n == 1) {
            return 1;
        }

        if (n <= 2 && m <= 2) {
            return 0;
        }

        if (n == 2 && m > 2) {
            return 1;
        }
        if (m == 2 && n > 2) {
            return 1;
        }

        int[][] arr = new int[n][m];
        arr[1][2] = 1;
        arr[2][1] = 1;

        for (int i = 2; i < n; i++) {
            int limit = (i * 3) - 1 > m ? m : (i * 3) - 1;
            for (int j = 2; j < limit; j++) {
                int count = 0;

                int n1 = i - 1;
                int m1 = j - 2;

                int n2 = i - 2;
                int m2 = j - 1;

                if (n1 >= 0 && m1 >= 0) {
                    count += arr[n1][m1];
                }
                if (n2 >= 0 && m2 >= 0) {
                    count += arr[n2][m2];
                }

                arr[i][j] = count;
            }
        }

        return arr[n - 1][m - 1];

    }
}
