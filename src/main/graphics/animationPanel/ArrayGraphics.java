package main.graphics.animationPanel;

import main.ArrayController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayGraphics extends JPanel {
    int timeScale;
    ArrayController arr;

    int xSize;
    int ySize;

    public void init(ArrayController arr, int xSize, int ySize, int timeScale){
        this.arr=arr;
        this.xSize=xSize;
        this.ySize=ySize;
        this.timeScale=timeScale;
        this.setSize(xSize,ySize);
        Timer timer = new Timer(timeScale, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
}
