package main.graphics;

import main.ArrayController;
import main.AudioController;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class collAnimation extends JPanel {
    ArrayController arr;
    int maxNum = -1;
    int xSize;
    int ySize;

    public collAnimation(ArrayController arr, int xSize, int ySize, int timeScale) {
        this.arr=arr;
        findMax(arr);
        this.xSize=xSize;
        this.ySize=ySize;
        Timer timer = new Timer(timeScale, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeSize();
                repaint();
            }
        });
        timer.start();
    }

    private void findMax(ArrayController arr){
        for(int i = 0 ; i < arr.length();i++){
            maxNum = Math.max(maxNum,arr.getNum(i));
        }
    }
    protected void changeSize(){
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xUnit = xSize/arr.length();
        int yUnit = ySize/(maxNum+3);
        for(int i = 0 ; i< arr.length() ; i++) {
            Graphics2D g2d = (Graphics2D) g.create();
            switch (arr.getMark(i)){
                case 0:
                    g2d.setColor(Color.BLACK);
                    break;
                case 1:
                    g2d.setColor(Color.RED);
                    break;
                case 2:
                    g2d.setColor(Color.GREEN);
                    break;
                default:
                    g2d.setColor(Color.BLUE);
            }

            g2d.fillRect(i*xUnit, 0, xUnit, arr.getNum(i)*yUnit);
            g2d.dispose();
        }
    }
}
