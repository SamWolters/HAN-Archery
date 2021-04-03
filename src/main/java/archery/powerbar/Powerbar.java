package archery.powerbar;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import archery.arrow.Arrow;
import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class Powerbar extends Dashboard {
    private int speed;
    private final int min = 0;
    private final int max = 200;

    private boolean hold = false;
    private int direction = 1;

    /**
     * Creates a powerbar
     *
     * @param world         The main class of the application
     * @param x             The x position
     * @param y             The y position
     * @param width         The dashboard width
     * @param height        The dashboard height
     *
     * @see Archery#addGameObject(GameObject this)
     */
    public Powerbar(Archery world, float x, float y, float width, float height) {
        super(x, y, width, height);

        world.addGameObject(this);
    }

    /**
     * Draws the powerbar
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        g.noStroke();

        g.textSize(Resources.Text.FONTSIZE_S - 5);
        g.textAlign(CENTER);

        g.fill(0);
        g.text("HIGH", getX() + 8, getY() - 10);
        g.text("LOW", getX() + 8, getY() + getHeight() + 20);

        g.fill(255, 0, 0);
        g.rect(getX() + 3, getY(), getWidth() - 6, getHeight());

        g.fill(0);
        g.rect(getX(), (getY() + getHeight()) - speed, getWidth(), 5);
    }

    /**
     * Moved the powerbar slider up and down
     */
    @Override
    public void update() {
        if (!hold) {
            if (speed == max) {
                direction = 0;
            } else if (speed == min) {
                direction = 1;
            }

            switch (direction) {
                case 0:
                    speed -= 2;
                    break;
                case 1:
                    speed += 2;
                    break;
            }
        }
    }

    /**
     * Get the projectile speed and set hold to true
     *
     * @return speed * 3
     */
    public float getProjectileSpeed() {
        hold = true;
        return speed * 3;
    }

    /**
     * Sets hold to false
     */
    public void setHold() {
        hold = false;
    }
}
