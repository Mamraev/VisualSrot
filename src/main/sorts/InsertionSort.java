package main.sorts;

import main.ArrayController;
import main.utils.Swaps;

public class InsertionSort implements VisualSort {
    void insertionSort(ArrayController arr,int timeScale) throws InterruptedException {
        int n = arr.length();
        for (int i = 1; i < n; ++i) {
            int key = arr.getNum(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.getNum(j) > key) {
                Swaps.swap(arr,j,j+1,timeScale);
                j = j - 1;
            }
            arr.setNum(j+1,key);
        }
    }
    @Override
    public void sort(ArrayController arr, int timeScale) throws InterruptedException {
        insertionSort(arr,timeScale);
        arr.finishSort(timeScale);
    }
}
