package archery.window;

//import jdk.javadoc.internal.tool.Start;
import archery.window.StartWindow;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Window extends Dashboard {

    StartWindow start;
//    private static float x, y, width, height;
//    private String title;
//    private ArrayList<Button> DasboardButtons;

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

    public void drawText(PGraphics g) {
        start.drawTextOnButton(g);

    }

    public void drawButtons(PGraphics g) {
        start.drawButtonsInWindow(g);
    }

    private void mainWindow(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }
}
