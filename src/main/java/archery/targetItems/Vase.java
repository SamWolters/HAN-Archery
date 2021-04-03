package archery.targetItems;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Vase extends SpriteObject implements TargetItem {
    public static final Sprite vaseSprite = new Sprite(Resources.Images.TARGET_ITEM_VASE);

    private int health = 200;

    /**
     * Creates a new SpriteObject
     *
     * @param x     The x position
     * @param y     The y position
     */
    public Vase(float x, float y) {
        super(vaseSprite);

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
        g.image(vaseSprite.getPImage(), x - vaseSprite.getWidth(), y);
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