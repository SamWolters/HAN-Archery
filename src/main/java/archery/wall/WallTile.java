package archery.wall;

import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class WallTile extends SpriteObject {
    public static Sprite wallSprite = new Sprite(Resources.Images.WALL);

    /**
     * Sets the X and Y to where to tiles should
     * be drew.
     *
     * @param x     X position of the tile
     * @param y     Y position of the tile
     */
    public WallTile(float x, float y) {
        super(wallSprite);

        setX(x);
        setY(y);
    }

    @Override
    public void update() {
    }
}
