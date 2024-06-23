package site.pixeldetective.swing.Component;

import javax.swing.*;
import java.awt.*;

public class CurrentBoardPanel extends JPanel {
    public CurrentBoardPanel() {

        setLayout(new GridLayout(3,2, 0, 10));
        setPreferredSize(new Dimension(100, 300));

        JLabel label1 = new JLabel("Hit");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label1);
        JLabel label2 = new JLabel("2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label2);
        JLabel label3 = new JLabel("Miss");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label3);
        JLabel label4 = new JLabel("4");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label4);
        JLabel label5 = new JLabel("Total");
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label5);
        JLabel label6 = new JLabel("6");
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(new Font("Arial", Font.PLAIN, 28));
        add(label6);
    }
}
