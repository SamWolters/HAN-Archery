package archery.window;

import archery.resources.Resources;
import processing.core.PGraphics;

public class StartWindow extends Window {
    public StartWindow(int x, int y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void drawText(PGraphics g) {
        g.fill(0, 0, 0);
        g.textSize(Resources.Text.FONTSIZE_M);
        g.text("Archery", getX() + getWidth() / 3 + getWidth() / 100, getY() + getHeight() / 7);
    }


    @Override
    public void drawButtons(PGraphics g) {
        g.rect(getX() + getWidth() / 3 + getWidth() / 100, getY() + getHeight() / 7, 100, 50);
    }
}
