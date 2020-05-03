package main;

import main.sorts.BubbleSort;
import main.sorts.MergeSort;
import main.sorts.SelectionSort;
import main.sorts.VisualSort;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void initSorting(int arrSize, VisualSort vSort,int timeScale, ArrayGraphics ar) throws InterruptedException {
        ArrayController arr = new ArrayController(arrSize);
        AudioController ac = new AudioController(arr);
        ac.start();
        ar.animate(arr,timeScale);

        vSort.sort(arr,timeScale);
    }

    public static void main(String[] args) throws InterruptedException, LineUnavailableException {
        int timeScale = 1;
        int arrSize = 200;

        ArrayGraphics ar = new ArrayGraphics();


        initSorting(arrSize,new BubbleSort(), timeScale, ar);
        initSorting(arrSize,new MergeSort(), timeScale, ar);
        initSorting(arrSize,new SelectionSort(), timeScale, ar);

    }


}
