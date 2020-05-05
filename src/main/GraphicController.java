package main;

import main.graphics.animationPanel.ArrayGraphics;

import javax.swing.*;

public class GraphicController extends JPanel{
    //window properties
    private int xSize = 800;
    private int ySize = 800;

    private ArrayGraphics graphics;

    GraphicController(ArrayGraphics graphics) {
        this.graphics = graphics;
        initFrame();
    }

    GraphicController(ArrayGraphics graphics, int xSize, int ySize) {
        this.xSize=xSize;
        this.ySize=ySize;
        this.graphics = graphics;
        initFrame();
    }

    public void initFrame(){
        this.setSize(xSize,ySize);

    }


    void setGraphics(ArrayGraphics graphics){
        this.graphics=graphics;
    }

    public void setSize(int x, int y){
        xSize=x;
        ySize=y;
    }

    void animate(ArrayController arr, int timeScale){
        this.removeAll();
        graphics.init(arr,xSize,ySize,timeScale);
        this.add(graphics);// make generic
        this.setVisible(true);
    }
}

