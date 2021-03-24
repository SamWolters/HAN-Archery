package archery.powerbar;

import archery.Archery;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;


import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.JPanel;



/*Tekent nog niks maar dit is testCode, die ook niks tekent*/

public class Power_bar extends JPanel {

    private int squareX = 500;
    private int squareY = 500;
    private int squareW = 50;
    private int squareH = 50;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW,squareH);
    }
}
