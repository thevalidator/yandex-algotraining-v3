/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class DequeueWithProtection {

    public static void main(String[] args) throws IOException {

        LinkedList<String> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            if (input.equals("exit")) {
                System.out.println("bye");
                break;
            } else if (input.startsWith("push_front")) {
                String number = input.substring(11);
                queue.addFirst(number);
                System.out.println("ok");
            } else if (input.startsWith("push_back")) {
                String number = input.substring(10);
                queue.addLast(number);
                System.out.println("ok");
            } else if (input.equals("pop_front")) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(queue.pollFirst());
                }
            } else if (input.equals("pop_back")) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(queue.pollLast());
                }
            } else if (input.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(queue.peekFirst());
                }
            } else if (input.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    System.out.println(queue.peekLast());
                }
            } else if (input.equals("size")) {
                System.out.println(queue.size());
            } else if (input.equals("clear")) {
                queue.clear();
                System.out.println("ok");
            }
        }
    }

}
