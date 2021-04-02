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
     * @param arrowType
     */
    public Archer(Archery world, float x, float y, ArrowTypes arrowType) {
        super(new Sprite(Resources.Images.ARCHER));
        setX(x);
        setY(y);

        this.world = world;

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
        if (world.levelStarted) {
            bow.releaseProjectile(powerbar.getProjectileSpeed());
        }
    }
}
