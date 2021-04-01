package archery.target;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Target extends SpriteObject {

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param world The sprite
     */
    public Target(Archery world, int x, int y) {
        super(new Sprite(Resources.Images.targetPerson));

        setX(x);
        setY(y);

        world.addGameObject(this);
    }

    @Override
    public void update() {

    }
}
