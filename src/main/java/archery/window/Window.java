package archery.window;

//import jdk.javadoc.internal.tool.Start;
import archery.window.StartWindow;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Window extends GameObject {
    public Window(int x, int y, float width, float height) {
        super(x, y, width, height);

        setZ(4);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }

    public TextObject createTextObject(String text, int textSize, float x, float y) {
        TextObject txt = new TextObject(text, textSize);
        txt.setX(x);
        txt.setY(y);
        txt.setZ(10);

        return txt;
    }
}
