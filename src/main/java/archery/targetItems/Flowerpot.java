package archery.targetItems;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Flowerpot  extends SpriteObject implements TargetItem {
    public static final Sprite flowerpotSprite = new Sprite(Resources.Images.TARGET_ITEM_FLOWERPOT);

    private int health = 250;

    /**
     * Creates a new SpriteObject
     *
     * @param x     The x position
     * @param y     The y position
     */
    public Flowerpot(float x, float y) {
        super(flowerpotSprite);

        setX(x);
        setY(y);
    }

    /**
     * Draws the imamge with a offset
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        g.image(flowerpotSprite.getPImage(), x - flowerpotSprite.getWidth(), y);
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
