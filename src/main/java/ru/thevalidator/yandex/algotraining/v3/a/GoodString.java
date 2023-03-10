/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class GoodString {

    public static void main(String[] args) {
        try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
            //try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                System.out.println("0");
            } else {

                int[] letters = new int[n];
                for (int i = 0; i < n; i++) {
                    letters[i] = Integer.parseInt(br.readLine());
                }

                long res = 0;
                for (int i = 0; i < n - 1; i++) {
                    int value = Math.min(letters[i], letters[i + 1]);
                    res += value;
                }

                System.out.println(res);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
