package archery.targetItems;

import archery.Archery;
import archery.arrow.Arrow;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

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
        
        System.out.println("Plaatsen: " + x);
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject gameObject: collidedGameObjects) {
            if (gameObject instanceof Arrow) {
                takeDamage(((Arrow) gameObject).doDamage());
            }
        }

    }

    @Override
    public void update() {

    }

    @Override
    public void mouseMoved(int x, int y) {
        super.mouseMoved(x, y);

//        System.out.println(x); //Heb deze effe uitgecomment want de console slaat op hol lol
    }
}
