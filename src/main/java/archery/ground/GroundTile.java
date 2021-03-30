package archery.ground;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class GroundTile extends SpriteObject {
    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param sprite The sprite
     */
    public GroundTile(Sprite sprite, float x, float y) {
        super(sprite);

        setX(x);
        setY(y);
    }

    @Override
    public void update() {

    }
}
