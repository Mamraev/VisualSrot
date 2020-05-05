package main;

import main.graphics.StatisticsPanel;
import main.graphics.animationPanel.CircleAnimation;
import main.graphics.animationPanel.collAnimation;
import main.sorts.*;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void initSorting(int arrSize, VisualSort vSort,int timeScale, GraphicController ar) throws InterruptedException {
        ArrayController arr = new ArrayController(arrSize);
        AudioController ac = new AudioController(arr);
        ac.start();
        ar.animate(arr,timeScale);

        vSort.sort(arr,timeScale);
    }

    public static void main(String[] args) throws InterruptedException, LineUnavailableException {
        JFrame frame = new MainFrame(1000,825);
        //GraphicController ar = new GraphicController(new collAnimation());
        GraphicController ar = new GraphicController(new CircleAnimation());

        frame.add(ar, BorderLayout.CENTER);
        frame.add(new StatisticsPanel(),BorderLayout.LINE_END);
        frame.setVisible(true);
        frame.setMinimumSize(frame.getPreferredSize());


        int timeScale = 5;
        int arrSize = 100;


        initSorting(arrSize,new InsertionSort(), timeScale, ar);
        initSorting(arrSize,new OddEvenSort(), timeScale, ar);
        initSorting(arrSize,new BubbleSort(), timeScale, ar);
        initSorting(arrSize,new MergeSort(), timeScale, ar);
        initSorting(arrSize,new SelectionSort(), timeScale, ar);

    }




}
