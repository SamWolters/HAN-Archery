package archery.window;

import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Window extends Dashboard {
    private static float x, y, width, height;
    private String title;
    private ArrayList<Buttons> DasboardButtons;

    public Window(int x, int y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        mainWindow(g);
        drawText(g);
        drawButtons(g);
    }

    public abstract void drawText(PGraphics g);

    public abstract void drawButtons(PGraphics g);

    private void mainWindow(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }
}
