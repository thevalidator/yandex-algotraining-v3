/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.c;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class DrunkPlay {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] player1 = scanner.nextLine().split(" ");
        String[] player2 = scanner.nextLine().split(" ");
        
        int counter = 0;
        
        LinkedList<Integer> p1 = new LinkedList<>();
        for (String string : player1) {
            p1.addLast(Integer.valueOf(string));
        }
        
        LinkedList<Integer> p2 = new LinkedList<>();
        for (String string : player2) {
            p2.addLast(Integer.valueOf(string));
        }
        
        String result = null;
        
        while (!p1.isEmpty() && !p2.isEmpty()) {
            int card1 = p1.pollFirst();
            int card2 = p2.pollFirst();
            boolean winner1 = false;
            
            if (card1 == 0 && card2 == 9) {
                winner1 = true;
            } else if (card2 == 0 && card1 == 9) {
            } else {
                if (card1 > card2) {
                    winner1 = true;
                }
            }
            
            System.out.println(">> " + card1 + " vs " + card2 + " w1=" + winner1);
            
            if (winner1) {
                p1.addLast(card1);
                p1.addLast(card2);
            } else {
                p2.addLast(card1);
                p2.addLast(card2);
            }
            
            if (++counter > 1_000_000) {
                result = "botva";
                break;
            }
        }
        
        if (result == null) {
            if (!p1.isEmpty()) {
                result = "first";
            } else {
                result = "second";
            }
            result = result + " " + counter;
        }
        
        
        System.out.println(result);
    }

}
