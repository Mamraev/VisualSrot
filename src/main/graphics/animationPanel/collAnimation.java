package main.graphics.animationPanel;

import java.awt.*;

public class collAnimation extends ArrayGraphics{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xUnit = xSize/arr.length();
        int yUnit = ySize/arr.getMax();
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
