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

    /**
     * Create a new target SpriteObject with in the world
     *
     * @param world         Main class of the application
     * @param x             X position of the target
     * @param y             Y position of the target
     * @param targetItem    Loads in target item
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

    /**
     * Adds person to the world.
     *
     * @param g
     */
    @Override
    public void draw(PGraphics g) {
        g.image(person.getPImage(), x - 60, y);
    }

    /**
     * Here the target item per level is added.
     *
     * @param world         Main class of the application
     * @param targetItem    Loads in target item
     */
    private void loadTargetItem(Archery world, TargetItems targetItem) {
        switch (targetItem) {
            case Apple:
                item = new Apple(getX(), getY() - Apple.appleSprite.getHeight());
                break;
            case Vase:
                item = new Vase(getX(), getY() - Vase.vaseSprite.getHeight());
                break;
            case Flowerpot:
                item = new Flowerpot(getX(), getY() - Flowerpot.flowerpotSprite.getHeight());
                break;
            case Balloon:
                item = new Balloon(getX(), getY() - Balloon.balloonSprite.getHeight());
                break;
        }
    }
}
