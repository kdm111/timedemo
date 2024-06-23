package site.pixeldetective.swing.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class DrawingComponent extends JPanel {
    public int userid;
    private BufferedImage image;
    public List<List<Integer>> drawCircles = new ArrayList<>();
    public Map<Integer, List<Integer>> answers = new HashMap<>();
    public int hit = 0;
    public int miss = 0;
    public CurrentBoardPanel cbp;

    public DrawingComponent(String imgURL) {
        answers.put(1, new ArrayList<>(Arrays.asList(217, 377, 130)));
        answers.put(2, new ArrayList<>(Arrays.asList(77, 87, 75)));
        answers.put(3, new ArrayList<>(Arrays.asList(388, 349, 75)));
        answers.put(4, new ArrayList<>(Arrays.asList(37, 413, 40)));


        try {
            URL url = new URL(imgURL);
            image = ImageIO.read(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
                int x = e.getX();
                int y = e.getY();
                double dist = 100000.0;
                int idx = -1;
                List lst = null;
                for (int k : answers.keySet()) {
                    List<Integer> val = answers.get(k);
                    double temp = Math.pow((x - val.get(0)) * (x - val.get(0))  + (y - val.get(1)) * (y - val.get(1)), 0.5);
                    if (temp <= val.get(2)) {
                        if (temp <= dist) {
                            dist = temp;
                            idx = k;
                            lst = new ArrayList<>(Arrays.asList(val.get(0), val.get(1), val.get(2), userid));
                        }
                    }

                }
                System.out.println(idx);
                if (idx != -1) {
                    hit += 1;
                    cbp.hitLabel.setText(hit + "");
                    cbp.totalLabel.setText(hit + miss + "");
                    drawCircles.add(lst);
                    repaint();
                } else {
                    miss += 1;
                    cbp.missLabel.setText(miss + "");
                    cbp.totalLabel.setText(hit + miss + "");

                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, this);
        }
        for (List<Integer> rect : drawCircles) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setStroke(new BasicStroke(3));
            if (rect.get(3) == userid) {
                g2d.setColor(Color.RED);
            } else {
                g2d.setColor(Color.BLUE);
            }
            g2d.drawOval(rect.get(0) - rect.get(2), rect.get(1) - rect.get(2), rect.get(2) * 2, rect.get(2) * 2);
            g2d.dispose();
        }

    }
}
