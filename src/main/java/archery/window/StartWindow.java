package archery.window;

import archery.resources.Resources;
import processing.core.PGraphics;

public class StartWindow extends Window {
    public StartWindow(int x, int y, float width, float height) {
        super(x, y, width, height);
    }

    public final int BUTTONWIDTH = 300;
    public final int BUTTONHEIGHT = 50;

    @Override
    public void drawText(PGraphics g) {
        g.textAlign(CENTER);
        g.fill(0, 0, 0);
        g.textSize(Resources.Text.FONTSIZE_M);
        g.text("Archery", getX() + getWidth() / 2, getY() + getHeight() / 7);
    }


    @Override
    public void drawButtons(PGraphics g) {
        g.fill(196, 196, 196);
        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 3, BUTTONWIDTH, BUTTONHEIGHT);
        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 2 + BUTTONHEIGHT, BUTTONWIDTH, BUTTONHEIGHT);
    }
}
