package com.denis.korolev.task2;

public class InsertionSort {

    public int[] sort(int[] array) {
        int[] newArray = array.clone();

        for (int i = 1; i < newArray.length; i++) {
            int current = newArray[i];
            int previousPosition = i - 1;

            while (previousPosition >= 0 && newArray[previousPosition] > current) {
                newArray[previousPosition + 1] = newArray[previousPosition];
                previousPosition--;
            }
            newArray[previousPosition + 1] = current;
        }
        return newArray;
    }
}
