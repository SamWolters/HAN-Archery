package archery.targetItems;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Vase extends SpriteObject implements TargetItem {
    private int health = 150;
    private Archery world;

    public static final Sprite vaseSprite = new Sprite(Resources.Images.TARGET_ITEM_VASE);

    public Vase(Archery world, float x, float y) {
        super(vaseSprite);

        this.world = world;

        setX(x);
        setY(y);
    }

    @Override
    public void draw(PGraphics g) {
        g.image(vaseSprite.getPImage(), x - vaseSprite.getWidth(), y);
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