package main.graphics.animationPanel;

import java.awt.*;

public class CircleAnimation extends ArrayGraphics {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xUnit = xSize/arr.length();
        for(int i = 0 ; i< arr.length() ; i++) {
            Graphics2D g2d = (Graphics2D) g.create();
            float spectrum = ((float)arr.getNum(i)/(float)(arr.length()-1))/1.5f;
            System.out.println(spectrum);
            g2d.setColor(Color.getHSBColor(spectrum ,1.0f,1.0f));
            g2d.fillRect(i*xUnit, 0, xUnit, ySize);
            g2d.dispose();
        }
    }
}
