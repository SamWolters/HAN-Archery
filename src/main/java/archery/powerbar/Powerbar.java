package archery.powerbar;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import archery.arrow.Arrow;
import processing.core.PGraphics;

public class Powerbar extends Dashboard {
    Arrow activeArrow;

    double increment = 2; //Increased dat het balkje sneller op en neer beweegd
    private int speed;
    private final int min = 0;
    private final int max = 200;

    private final String HIGH = "HIGH";
    private final String LOW = "LOW";

    private boolean hold = false;
    private int direction = 1;

    public Powerbar(Archery world, float x, float y, float width, float height) {
        super(x, y, width, height);

        world.addGameObject(this);
    }

    @Override
    public void draw(PGraphics g) {
        g.noStroke();

        g.textSize(Resources.Text.FONTSIZE_S - 5);
        g.textAlign(CENTER);
        g.text(HIGH, getX() + 8, getY() - 10);
        g.text(LOW, getX() + 8, getY() + getHeight() + 20);

        g.fill(255, 0, 0);
        g.rect(getX() + 3, getY(), getWidth() - 6, getHeight());

        g.fill(0);

        g.rect(getX(), (getY() + getHeight()) - speed, getWidth(), 5);
    }

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
                    speed -= increment;
                    break;
                case 1:
                    speed += increment;
                    break;
            }
        }
    }

    public float getProjectileSpeed() {
        hold = true;
        return speed * 3;
    }

    public void setHold() {
        hold = false;
    }
}
