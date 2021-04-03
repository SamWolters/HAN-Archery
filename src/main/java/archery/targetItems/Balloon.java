package archery.targetItems;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Balloon extends SpriteObject implements TargetItem {
    public static final Sprite balloonSprite = new Sprite(Resources.Images.TARGET_ITEM_BALLOON);

    private int health = 100;

    /**
     * Creates a new SpriteObject
     *
     * @param x     The x position
     * @param y     The y position
     */
    public Balloon(float x, float y) {
        super(balloonSprite);

        setX(x);
        setY(y);
        setWidth(30);
        setHeight(30);
    }

    /**
     * Draws the imamge with a offset
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        g.image(balloonSprite.getPImage(), x - balloonSprite.getWidth(), y);
    }

    /**
     * Removes the damamge amount of health
     *
     * @param damage        The amount of damage was done and needs to be taken of health
     */
    public void takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Return the current health
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    @Override
    public void update() { }
}
