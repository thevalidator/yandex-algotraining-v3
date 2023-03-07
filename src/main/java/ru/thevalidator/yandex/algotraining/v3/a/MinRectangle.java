/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.a;

import java.util.Scanner;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class MinRectangle {

    public static void main(String[] args) {

        int painted = 0;
        int[][] coord = null;
        Scanner scanner = new Scanner(System.in);
        int counter = -1;

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("-")) {
                break;
            }
            if (counter == -1) {
                painted = Integer.parseInt(input);
                coord = new int[painted][2];
            } else {
                var tmp = input.split(" ");
                coord[counter][0] = Integer.parseInt(tmp[0]);
                coord[counter][1] = Integer.parseInt(tmp[1]);
            }
            counter++;
        }
        
        int minY = 1_000_000_000;
        int maxY = 0;
        int minX = 1_000_000_000;
        int maxX = 0;
        
        for (int i = 0; i < coord.length; i++) {
            int x = coord[i][0];
            int y = coord[i][1];
            minY = Math.min(minY, y);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            maxX = Math.max(maxX, x);
        }
        
        System.out.printf("%d %d %d %d\n", minX, minY, maxX, maxY);

    }

}
