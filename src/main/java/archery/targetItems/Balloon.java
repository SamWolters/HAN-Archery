package archery.targetItems;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.Random;

public class Balloon extends SpriteObject implements TargetItem {
    private int health = 100;
    private Archery world;

    public static final Sprite balloonSprite = new Sprite(Resources.Images.TARGET_ITEM_BALLOON);

    public Balloon(Archery world, float x, float y) {
        super(balloonSprite);

        this.world = world;

        setX(x);
        setY(y);
        setWidth(30);
        setHeight(30);
    }

    @Override
    public void draw(PGraphics g) {
        g.image(balloonSprite.getPImage(), x - balloonSprite.getWidth(), y);
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
