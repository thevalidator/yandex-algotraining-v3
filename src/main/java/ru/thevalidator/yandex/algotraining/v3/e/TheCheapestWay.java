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
public class TheCheapestWay {
    public static void main(String[] args) {
        
        int n;
        int m;
        int[][] arr;
        
        //try ( BufferedReader br = Files.newBufferedReader(Paths.get("task.txt"));) {
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            var limits = br.readLine().split(" ");
            n = Integer.parseInt(limits[0]);
            m = Integer.parseInt(limits[1]);
            
            
            arr = new int[n + 1][m + 1];
            
            for (int i = 0; i <= n; i++) {
                arr[i][0] = Integer.MAX_VALUE;
            }
            arr[1][0] = 0;
            for (int i = 0; i <= m; i++) {
                arr[0][i] = Integer.MAX_VALUE;
            }
            
            for (int i = 1; i <= n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    arr[i][j] = Integer.parseInt(line[j-1]);
                }
            }
            
            int result = calc(n, m, arr);
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static int calc(int n, int m, int[][] arr) {
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += Math.min(arr[i-1][j], arr[i][j-1]);
            }
        }
        
        return arr[n][m];
    }
}
