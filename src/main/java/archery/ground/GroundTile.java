package archery.ground;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class GroundTile extends SpriteObject {
    public static Sprite groundSprite = new Sprite(Resources.Images.ground);

    public GroundTile(float x, float y) {
        super(groundSprite);

        setX(x);
        setY(y);
    }

    @Override
    public void update() {

    }
}
