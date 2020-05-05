package main.sorts;

import main.ArrayController;
import main.utils.Swaps;

public class OddEvenSort implements VisualSort{
    public void oddEvenSort(ArrayController arr, int timeScale) throws InterruptedException {
        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted)
        {
            isSorted = true;
            int temp =0;

            // Perform Bubble sort on odd indexed element
            for (int i=1; i<=arr.length()-2; i=i+2)
            {
                if (arr.getNum(i) > arr.getNum(i+1))
                {
                    Swaps.swap(arr,i,i+1,timeScale);
                    isSorted = false;
                }
            }

            // Perform Bubble sort on even indexed element
            for (int i=0; i<=arr.length()-2; i=i+2)
            {
                if (arr.getNum(i) > arr.getNum(i+1))
                {
                    Swaps.swap(arr,i,i+1,timeScale);
                    isSorted = false;
                }
            }
        }
    }

    @Override
    public void sort(ArrayController arr, int timeScale) throws InterruptedException {
        oddEvenSort(arr,timeScale);
        arr.finishSort(timeScale);
    }
}
