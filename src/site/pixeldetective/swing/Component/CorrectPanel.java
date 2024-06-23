package site.pixeldetective.swing.Component;

import javax.swing.*;
import java.awt.*;

public class CorrectPanel extends JPanel {
    public CorrectPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.YELLOW);
        JLabel correctLabel = new JLabel(" 1/5", SwingConstants.CENTER);
        setPreferredSize(new Dimension(100, 75));
        correctLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(correctLabel, BorderLayout.CENTER);

    }
}
