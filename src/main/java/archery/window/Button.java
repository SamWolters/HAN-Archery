package archery.window;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PGraphics;

public class Button extends GameObject implements IMouseInput {

    private String text;
    private int textSize;

    public Button(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(x, y, width, height);
        setZ(10);

        this.text = text;
        this.textSize = textSize;

        world.addGameObject(this);
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
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.fill(255, 0,0);
        g.rect(getX(), getY(), getWidth(), getHeight());

        g.fill(0);
        g.textSize(textSize);
        g.textAlign(CENTER);
        g.text(text, getX() + getWidth() / 2, getY() + getHeight() / 2);
    }
}
