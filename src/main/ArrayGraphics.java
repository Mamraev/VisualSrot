package main;

import main.graphics.collAnimation;

import javax.swing.*;

public class ArrayGraphics extends JFrame{
    //window properties
    JFrame frame = new JFrame("Testing");
    int xSize = 1200;
    int ySize = 800;
    public ArrayGraphics() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(xSize,ySize);
        frame.setLocationRelativeTo(null);
    }

    public void animate(ArrayController arr,int timeScale){
        System.out.println("animating");
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new collAnimation(arr,xSize,ySize,timeScale));// make generic
        frame.setVisible(true);
    }
}

