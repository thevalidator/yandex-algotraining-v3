/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class Calculator {

    public static void main(String[] args) {

        int target = 962340;//1_000_000;//962340;//1_000_000;// = 5;

//////        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
//////            target = Integer.parseInt(br.readLine());
//////        } catch (Exception e) {
//////        }
        System.out.println(countOperations(target));

    }

    public static String countOperations(int target) {

        int[] count = new int[target + 1];
        int[] index = new int[target + 1];

        if (target == 1) {
            return "0\n1";
        } else if (target < 4) {
            return "1\n1 " + target;
        }

        count[0] = 0;
        count[1] = 1;
        count[2] = 1;
        count[3] = 1;

        for (int i = 4; i <= target; i++) {

            int steps = target;

            if (i % 3 == 0) {
                steps = count[i / 3] + 1;
                count[i] = count[i / 3] + 1;
                index[i] = i / 3;
            }
            if (i % 2 == 0) {
                int tmp = (count[i / 2] + 1);
                if (tmp < steps) {
                    steps = tmp;
                    count[i] = count[i / 2] + 1;
                    index[i] = i / 2;
                }
            }
            if (count[i - 1] + 1 < steps) {
                count[i] = count[i - 1] + 1;
                index[i] = i - 1;
            }

        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = target; i > 1;) {
            list.add(i);
            i = index[i];
        }
        list.add(1);
        StringBuilder sb = new StringBuilder();
        sb.append(count[target]).append("\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

}
