package archery.buttons;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PGraphics;

public class Button extends GameObject implements IMouseInput {

    private String text;
    private int textSize;

    /**
     * The GameObject button is added to the world.
     * The button is positioned with Y as X axis.
     * Then the width and height are specified.
     * At last the text passed on in the param and
     * the text size is specified
     *
     * @param world     Loads in the world.
     * @param x         X position of the button
     * @param y         Y position of the button
     * @param width     Width of the button
     * @param height    Height of the button
     * @param text      Adds text to the button
     * @param textSize  Adds text size to the text
     *
     * @see Button
     */
    public Button(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(x, y, width, height);
        setZ(10);

        this.text = text;
        this.textSize = textSize;

        world.addGameObject(this);
    }

    @Override
    public void mousePressed(int x, int y, int button) { }

    @Override
    public void mouseReleased(int x, int y, int button) { }

    @Override
    public void mouseMoved(int x, int y) { }

    @Override
    public void mouseDragged(int x, int y, int button) { }

    @Override
    public void mouseWheel(int direction) { }

    @Override
    public void update() { }

    /**
     * In the draw method the button is given a stroke, stroke thickness,
     * the color of the button and where it should be draw with a height
     * and width of the button.
     *
     * Then text get added to the button. First the text is given no stroke.
     * Then a color gets added to text, the text size is added, the text gets aligned to the center
     * then the position of the text, and last the width and height is added
     *
     * @param g PGraphics object will be given by the GameEngine.
     *
     */
    @Override
    public void draw(PGraphics g) {
        g.stroke(255);
        g.strokeWeight(1);
        g.fill(196, 196, 196);
        g.rect(getX(), getY(), getWidth(), getHeight());

        g.noStroke();
        g.fill(0);
        g.textSize(textSize);
        g.textAlign(CENTER);
        g.text(text, getX() + getWidth() / 2, getY() + getHeight() / 2 + 10);
    }
}
