package archery.targetItems;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Flowerpot  extends SpriteObject implements TargetItem {
    private int health = 150;
    private Archery world;

    public static final Sprite flowerpotSprite = new Sprite(Resources.Images.TARGET_ITEM_FLOWERPOT);

    public Flowerpot(Archery world, float x, float y) {
        super(flowerpotSprite);

        this.world = world;

        setX(x);
        setY(y);
    }

    @Override
    public void draw(PGraphics g) {
        g.image(flowerpotSprite.getPImage(), x - flowerpotSprite.getWidth(), y);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void update() {

    }
}
