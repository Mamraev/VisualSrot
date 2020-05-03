package main;

import java.util.Random;

/*
Used to control the array, statistics and its current state
marked used to save the index state in the current time
 */
public class ArrayController {
    int[] arr;
    int[] marked;
    int swaps=0;
    int compares=0;

    public ArrayController(int n) {
        initArray(n);
        this.marked = new int[arr.length];
    }

    private void initArray(int n){
        arr=new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = i+1;
        }
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
    }
    public int getNum(int i){
        return arr[i];
    }

    public void setNum(int i, int n){
        arr[i]=n;
    }

    public void setMark(int i, int mark){
        marked[i] = mark;
    }

    public int getMark(int i){
        return marked[i];
    }

    public void clearAllMarks(){
        marked= new int[arr.length];
    }

    public int length(){
        return arr.length;
    }

    public void finishSort(int timeScale) throws InterruptedException {
        for(int i = 0 ; i < marked.length ;i ++){
            Thread.sleep(timeScale);
            marked[i]=2;
        }
    }
}
