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
     * Creates a new SpriteObject, powerbar and bow. With the
     * given params the archer is placed in the world (game window).
     *
     * @param world         The main class of the application
     * @param x             The x position
     * @param y             The y position
     * @param arrowType     The arrow type for the bow
     *
     * @see Archery
     */
    public Archer(Archery world, float x, float y, ArrowTypes arrowType) {
        super(new Sprite(Resources.Images.ARCHER));
        setX(x);
        setY(y);

        this.world = world;

        powerbar = new Powerbar(world,getX() - 50, getY(), 20, 200);
        bow = new Bow(world, getX() + 80, getCenterY() - 185, arrowType);
    }

    /**
     * Gets the active arrow from bow and checks if the arrow
     * has collided with another gameObject. If so the powerbar
     * method setHold() is called
     *
     * @see Powerbar#setHold() 
     */
    @Override
    public void update() {
        Arrow arrow = bow.getActiveArrow();

        if (arrow.collided) {
            powerbar.setHold();
        }
    }

    /**
     * When the mouse is clicked this event will check
     * if the level was started. If the level was started
     * the bow will release the arrow at the given speed from powerbar
     *
     * @param x         The x position of the mouse
     * @param y         The y position of the mouse
     * @param button    The id of pressed mouse button
     *
     * @see Bow#releaseProjectile(float speed) 
     * @see Powerbar#getProjectileSpeed() 
     */
    @Override
    public void mouseClicked(int x, int y, int button) {
        if (world.levelStarted) {
            bow.releaseProjectile(powerbar.getProjectileSpeed());
        }
    }
}
