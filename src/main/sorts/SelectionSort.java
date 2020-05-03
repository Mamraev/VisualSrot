package main.sorts;

import main.ArrayController;
import main.utils.Swaps;

public class SelectionSort implements VisualSort {

    void selectionSort(ArrayController arr, int timeScale) throws InterruptedException {
        int n = arr.length();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                arr.setMark(min_idx,1);

                arr.setMark(j,1);
                Thread.sleep(timeScale/2);

                if (arr.getNum(j) < arr.getNum(min_idx)) {
                    arr.setMark(min_idx, 0);
                    Thread.sleep(timeScale);
                    min_idx = j;
                }
                arr.setMark(j, 0);
            }

            // Swap the found minimum element with the first
            // element
            arr.setMark(min_idx, 0);

            Swaps.swapNM(arr,min_idx,i,timeScale);
        }
    }
    @Override
    public void sort(ArrayController arr, int timeScale) throws InterruptedException {
        selectionSort(arr,timeScale);
        arr.finishSort(timeScale);

    }
}
