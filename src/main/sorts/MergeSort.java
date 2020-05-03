package main.sorts;

import main.ArrayController;
import main.utils.Swaps;

public class MergeSort implements VisualSort {
    static void merge(ArrayController arr, int start, int mid, int end, int timeScale) throws InterruptedException {
        int start2 = mid + 1;

        // If the direct merge is already sorted
        if (arr.getNum(mid) <= arr.getNum(start2)) {
            return;
        }

        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {

            // If element 1 is in right place
            if (arr.getNum(start) <= arr.getNum(start2)) {
                start++;
            }
            else {
                int value = arr.getNum(start2);
                int index = start2;

                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start) {
                    Swaps.swap(arr,index,index-1,timeScale);
                    index--;
                }
                arr.setNum(start,value);

                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }
    }

    /* l is for left index and r is right index of the
       sub-array of arr to be sorted */
    static void mergeSort(ArrayController arr, int l, int r, int timeScale) throws InterruptedException {
        if (l < r) {

            // Same as (l + r) / 2, but avoids overflow
            // for large l and r
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m, timeScale);
            mergeSort(arr, m + 1, r, timeScale);

            merge(arr, l, m, r, timeScale);
        }
    }

    public void sort(ArrayController arr, int timeScale) throws InterruptedException {
        mergeSort(arr,0,arr.length()-1,timeScale);
        arr.finishSort(timeScale);
    }
}
