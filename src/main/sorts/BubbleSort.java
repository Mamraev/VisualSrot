package main.sorts;

import main.ArrayController;
import main.utils.Swaps;

public class BubbleSort implements VisualSort {
    public void bubbleSort(ArrayController arr,int timeScale) throws InterruptedException {
        int n = arr.length();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr.getNum(j) > arr.getNum(j+1))
                {
                    Swaps.swap(arr,j,j+1,timeScale);
                }

    }

    @Override
    public void sort(ArrayController arr, int timeScale) throws InterruptedException{
        bubbleSort(arr,timeScale);
        arr.finishSort(timeScale);
    }
}
