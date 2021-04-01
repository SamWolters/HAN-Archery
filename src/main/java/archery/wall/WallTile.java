package archery.wall;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class WallTile extends SpriteObject {
    public static Sprite wallSprite = new Sprite(Resources.Images.wall);

    public WallTile(float x, float y) {
        super(wallSprite);

        setX(x);
        setY(y);
    }

    @Override
    public void update() {
    }
}
