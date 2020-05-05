package main.graphics;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    public StatisticsPanel() {
        this.setSize(200,800);
        this.setLayout(new FlowLayout());
        this.setForeground(Color.BLUE);
        JLabel title = new JLabel("Sort Visualization",SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 15));
        title.setForeground(new Color(120, 90, 40));
        title.setBorder(BorderFactory.createLineBorder(new Color(120, 90, 40)));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);
    }
}
