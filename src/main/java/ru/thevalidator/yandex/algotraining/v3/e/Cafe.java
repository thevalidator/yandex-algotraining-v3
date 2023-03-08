/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Cafe {

    public static void main(String[] args) {

        try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
            //try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            var days = Integer.parseInt(br.readLine());
            int[] prices = new int[days];

            for (int i = 0; i < days; i++) {
                prices[i] = Integer.parseInt(br.readLine());
            }

            System.out.println(calc(days, prices));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String calc(int daysNumber, int[] prices) {

        if (daysNumber == 0) {
            return "0\n0 0";
        }

        int[][] arr = new int[daysNumber + 1][daysNumber];
        for (int i = 0; i <= daysNumber; i++) {
            arr[i][0] = -1;
        }

        if (prices[0] > 100) {
            arr[1][0] = prices[0];
        } else {
            arr[0][0] = prices[0];
        }

        for (int day = 1; day < daysNumber; day++) {
            for (int coupon = 0; coupon < daysNumber; coupon++) {

                int cost1 = 30_000;
                int cost2 = 30_000;

                if (arr[coupon + 1][day - 1] >= 0) {
                    cost1 = arr[coupon + 1][day - 1];
                }

                if (prices[day] > 100 && coupon > 0) {
                    if (arr[coupon - 1][day - 1] >= 0) {
                        cost2 = arr[coupon - 1][day - 1] + prices[day];
                    }

                } else {
                    if (arr[coupon][day - 1] >= 0) {
                        cost2 = arr[coupon][day - 1] + prices[day];
                    }
                }
                arr[coupon][day] = Math.min(cost1, cost2);

            }
        }

        int minPrice = Integer.MAX_VALUE;
        int couponsLeft = 0;

        for (int day = daysNumber; day >= 0; day--) {
            if (arr[day][daysNumber - 1] > 0 && minPrice > arr[day][daysNumber - 1]) {
                minPrice = arr[day][daysNumber - 1];
                couponsLeft = day;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minPrice).append("\n").append(couponsLeft).append(" ");

        int value = couponsLeft;
        int couponsUsed = 0;
        List<Integer> daysByCoupons = new ArrayList<>();
        for (int i = daysNumber - 1; i > 0; i--) {
            int cost = arr[value][i];
            if (prices[i] != 0 && cost == arr[value + 1][i - 1]) {
                daysByCoupons.add(i + 1);
                couponsUsed++;
                value++;
            } else if (value != 0 && cost == arr[value - 1][i - 1] + prices[i]) {
                value--;
            }
        }

        sb.append(couponsUsed);
        for (int i = daysByCoupons.size() - 1; i >= 0; i--) {
            sb.append("\n").append(daysByCoupons.get(i));

        }

        return sb.toString();
    }
}
