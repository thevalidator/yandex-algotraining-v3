/*
 * Copyright (C) 2023 thevalidator
 */
package ru.thevalidator.yandex.algotraining.v3.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class QueueWithProtection {

    public static void main(String[] args) throws IOException {

        //LinkedList<Integer> queue = new LinkedList<>();
        Queue queue = new Queue(50);
        //List<String> list = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            if (input.equals("exit")) {
                System.out.println("bye");
                break;
            } else if (input.startsWith("push")) {
                //Integer number = Integer.valueOf(input.substring(5).trim());
                String number = input.substring(5);
                //queue.add(number);
                queue.push(number);
                //list.add(number);
                System.out.println("ok");
            } else if (input.equals("pop")) {
                //if (list.isEmpty()) {
                if (queue.size() == 0) {
                    //if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    //System.out.println(list.remove(0));
                    System.out.println(queue.pop());
                    //System.out.println(queue.pollFirst());
                }
            } else if (input.equals("front")) {
                //if (list.isEmpty()) {
                if (queue.size() == 0) {
                    //if (queue.isEmpty()) {
                    System.out.println("error");
                } else {
                    //System.out.println(list.get(0));
                    System.out.println(queue.front());
                    //System.out.println(queue.peekFirst());
                }
            } else if (input.equals("size")) {
                //System.out.println(list.size());
                System.out.println(queue.size());
            } else if (input.equals("clear")) {
                //list.clear();
                queue.clear();
                System.out.println("ok");
            }
        }
    }

}

class Queue {

    private int maxSize;
    private String[] array;
    private int front;
    private int rear;
    private int items;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = new String[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public void push(String n) {
        if (items == maxSize) {
            increaseArray();
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        array[++rear] = n;
        items++;
    }

    public String pop() {
        String tmp = array[front++];
        if (front == maxSize) {
            front = 0;
        }
        items--;
        return tmp;
    }

    public String front() {
        return array[front];
    }

    public int size() {
        return items;
    }

    public void clear() {
        front = 0;
        rear = -1;
        items = 0;
    }

    private void increaseArray() {
        maxSize *= 2;
        int tmpItems = items;
        String[] tmpArray = new String[maxSize];
        for (int i = 0; i < tmpItems; i++) {
            tmpArray[i] = this.pop();
        }
        array = tmpArray;
        front = 0;
        items = tmpItems;
        rear = items - 1;
    }

}
