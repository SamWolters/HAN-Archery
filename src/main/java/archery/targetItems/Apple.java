package archery.targetItems;

import archery.Archery;
import archery.arrow.Arrow;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.List;

public class Apple extends SpriteObject implements TargetItem {
    private int health = 150;
    private Archery world;

    public static final Sprite appleSprite = new Sprite(Resources.Images.TARGET_ITEM_APPLE);

    public Apple(Archery world, float x, float y) {
        super(appleSprite);

        this.world = world;

        setX(x);
        setY(y);
    }

    @Override
    public void draw(PGraphics g) {
        g.image(appleSprite.getPImage(), x - appleSprite.getWidth(), y);
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
