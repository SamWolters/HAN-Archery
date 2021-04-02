package archery.target;

import archery.Archery;
import archery.enums.TargetItems;
import archery.resources.Resources;
import archery.targetItems.*;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class Target extends SpriteObject {
    private TargetItem item;
    private Sprite person;
    private final int OFFSET_ITEM = 40;
    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param world The sprite
     */
    public Target(Archery world, int x, int y, TargetItems targetItem) {
        super(new Sprite(Resources.Images.TARGET_PERSON));
        person = new Sprite(Resources.Images.TARGET_PERSON);

        setX(x + 60);
        setY(y);

        setWidth(40);

        world.addGameObject(this);
        loadTargetItem(world, targetItem);
        world.addGameObject((GameObject) item);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics g) {
        g.image(person.getPImage(), x - 60, y);
    }

    private void loadTargetItem(Archery world, TargetItems targetItem) {
        switch (targetItem) {
            case Apple:
                item = new Apple(world, getX(), getY() - Apple.appleSprite.getHeight());
                break;
            case Vase:
                item = new Vase(world, getX(), getY() - Vase.vaseSprite.getHeight());
                break;
            case Flowerpot:
                item = new Flowerpot(world, getX(), getY() - Flowerpot.flowerpotSprite.getHeight());
                break;
            case Balloon:
                item = new Balloon(world, getX(), getY() - Balloon.balloonSprite.getHeight());
                break;
        }
    }
}
