package archery.window;

import processing.core.PGraphics;

public class StartWindow extends Window {
    public StartWindow(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void drawText(PGraphics g) {
//        g.text(this.setTitle(), getX() + getWidth() / 3, getY() + getHeight() / 7);

    }

    @Override
    public void drawButtons(PGraphics g) {
        super.drawButtons(g);
    }
}
