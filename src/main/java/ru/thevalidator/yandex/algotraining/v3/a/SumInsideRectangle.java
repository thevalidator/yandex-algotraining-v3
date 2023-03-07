/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class SumInsideRectangle {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String data[] = scanner.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);
        int[][] matrix = new int[n][m];
        
//        for (int i = 0; i < n; i++) {
//            String row[] = scanner.nextLine().split(" ");
//            for (int j = 0; j < m; j++) {
//                matrix[i][j] = Integer.parseInt(row[j]);
//            }
//        }
//        
//        for (int i = 0; i < k; i++) {
//            String rectangle[] = scanner.nextLine().split(" ");
//            int x1 = Integer.parseInt(rectangle[0]);
//            int y1 = Integer.parseInt(rectangle[1]);
//            int x2 = Integer.parseInt(rectangle[2]);
//            int y2 = Integer.parseInt(rectangle[3]);
//            
//            int sum = 0;
//            for (int j = x1 - 1; j < x2; j++) {
//                for (int l = y1 - 1; l < y2; l++) {
//                    sum += matrix[j][l];
//                }
//            }
//            
//            System.out.println(sum);
//            
//        }

        List<String> rows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(scanner.nextLine());
        }
        
        for (int i = 0; i < k; i++) {
            String rectangle[] = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(rectangle[0]);
            int y1 = Integer.parseInt(rectangle[1]);
            int x2 = Integer.parseInt(rectangle[2]);
            int y2 = Integer.parseInt(rectangle[3]);
            
            int sum = 0;
            for (int j = x1 - 1; j < x2; j++) {
                for (int l = y1 - 1; l < y2; l++) {
                    String[] numbers = rows.get(j).split(" ");
                    sum += Integer.parseInt(numbers[l]);
                    //sum += matrix[j][l];
                }
            }
            
        }

    }

}
