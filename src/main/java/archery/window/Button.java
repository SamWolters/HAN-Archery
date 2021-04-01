package archery.window;

import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PGraphics;

public class Button extends Dashboard implements IMouseInput {

    private String title;
    public final int BUTTONWIDTH = 300;
    public final int BUTTONHEIGHT = 50;

    public Button(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void mousePressed(int x, int y, int button) {


    }

    @Override
    public void mouseReleased(int x, int y, int button) {

    }

    @Override
    public void mouseClicked(int x, int y, int button) {


    }

    @Override
    public void mouseMoved(int x, int y) {

    }

    @Override
    public void mouseDragged(int x, int y, int button) {

    }

    @Override
    public void mouseWheel(int direction) {

    }


    @Override
    public void draw(PGraphics g) {
        drawButton(g);
        drawTitleInButton(g);
    }

        public void drawButton(PGraphics g) {
        g.fill(196, 196, 196);
        g.rect(getX() , getY() , getWidth(), getWidth());
        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 2 + BUTTONHEIGHT, BUTTONWIDTH, BUTTONHEIGHT);
    }


//    public void drawButton(PGraphics g) {
//        g.fill(196, 196, 196);
//        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 3, BUTTONWIDTH, BUTTONHEIGHT);
//        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 2 + BUTTONHEIGHT, BUTTONWIDTH, BUTTONHEIGHT);
//    }

//    public void drawTitleInButton(PGraphics g) {
//        g.textAlign(CENTER);
//        g.textSize(Resources.Text.FONTSIZE_S);
//        g.fill(0, 0, 0);
//        g.text(title, getX() + getWidth() / 2 + BUTTONHEIGHT, getY() + getHeight() / 3 + 35);
//    }

    public void setTitle(String title) {
        this.title = title;
    }
}
