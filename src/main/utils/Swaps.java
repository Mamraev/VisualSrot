package main.utils;

import main.ArrayController;

public class Swaps {
    public static void swap(ArrayController arr, int i , int j){
        arr.setMark(i,1);
        arr.setMark(j,1);
        int temp = arr.getNum(i);
        arr.setNum(i,arr.getNum(j));
        arr.setNum(j,temp);

        arr.setMark(i,0);
        arr.setMark(j,0);
    }

    public static void swap(ArrayController arr, int i , int j, int timeScale) throws InterruptedException {
        arr.setMark(i,1);
        arr.setMark(j,1);
        int temp = arr.getNum(i);
        arr.setNum(i,arr.getNum(j));
        arr.setNum(j,temp);
        Thread.sleep(timeScale);
        arr.setMark(i,0);
        arr.setMark(j,0);
    }

    public static void swapNM(ArrayController arr, int i , int j, int timeScale) throws InterruptedException {
        int temp = arr.getNum(i);
        arr.setNum(i,arr.getNum(j));
        arr.setNum(j,temp);
        Thread.sleep(timeScale);

    }


}
