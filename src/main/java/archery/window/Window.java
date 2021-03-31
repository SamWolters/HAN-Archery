package archery.window;

import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;

import javax.swing.*;
import java.util.ArrayList;

public class Window extends Dashboard {
    private static float x, y, width, height;
    private String title;
    private ArrayList<Buttons> DasboardButtons;

    public Window(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        mainWindow(g);
        titelInWindow(g, getX() + getWidth() / 3, getY() + getHeight() / 7, title);

        drawText(g);
        drawButtons(g);
    }

    public void drawText(PGraphics g) {

    }
    public void drawButtons(PGraphics g) {}

    public void setTitle(String title) {
        this.title = title;
    }

    private void mainWindow(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }

    private void titelInWindow(PGraphics g, float x, float y, String title) {
        g.fill(0, 125, 235);
        g.textSize(48);
        g.text(title, x, y);
    }
}
