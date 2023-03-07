/*
 * Copyright (C) 2023 thevalidator
 */

package ru.thevalidator.yandex.algotraining.v3.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author thevalidator <the.validator@yandex.ru>
 */
public class PriorityHeap {
    
    public static void main(String[] args) throws IOException {
        
        Heap heap = new Heap(1_000_000);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '0') {
                int number = Integer.parseInt(line.substring(2));
                heap.insert(number);
            } else {
                System.out.println(heap.extract());
            }
        }
    }

}

class Heap {
    
    private int capacity;
    private int[] array;
    private int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        size = 0;
    }
    
    public void insert(int number) {
        array[size] = number;
        sieveUp(size);
        size++;
    }
    
    public int extract() {
        int extracted = array[0];
        array[0] = array[size - 1];
        sieveDown(0);
        size--;
        return extracted;
    }
    
    private void sieveUp(int index) {
        int inserted = array[index];
        int parentIndex = (index - 1) / 2;
        
        while (index > 0 && array[parentIndex] < inserted) {            
            array[index] = array[parentIndex];
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
        
        array[index] = inserted;
    }

    private void sieveDown(int index) {
        int largerIndex;
        int top = array[index];
        while (index < size / 2) {            
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            
            if (rightChildIndex < size && array[leftChildIndex] < array[rightChildIndex]) {
                largerIndex = rightChildIndex;
            } else {
                largerIndex = leftChildIndex;
            }
            
            if (top >= array[largerIndex]) {
                break;
            }
            
            array[index] = array[largerIndex];
            index = largerIndex;
        }
        array[index] = top;
    }
    
}
