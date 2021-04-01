package archery.archer;

import archery.Archery;
import archery.arrow.Arrow;
import archery.enums.ArrowTypes;
import archery.powerbar.Powerbar;
import archery.resources.Resources;
import archery.bow.Bow;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Archer extends SpriteObject {

    Archery world;
    Bow bow;
    Powerbar powerbar;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param world The sprite
     */
    public Archer(Archery world, float x, float y, ArrowTypes arrowType) {
        super(new Sprite(Resources.Images.archer));
        setX(x);
        setY(y);

        powerbar = new Powerbar(world,getX() - 50, getY(), 20, 200);
        bow = new Bow(world, getX() + 80, getCenterY() - 155, arrowType);
    }

    @Override
    public void update() {
        Arrow arrow = bow.getActiveArrow();

        if (arrow.collided) {
            powerbar.setHold();
        }
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        bow.releaseProjectile(powerbar.getProjectileSpeed());
    }
}
