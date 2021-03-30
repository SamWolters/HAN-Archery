package archery.archer;

import archery.Archery;
import archery.powerbar.Powerbar;
import archery.weapons.Bow;
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
    public Archer(Archery world, float x, float y) {
        super(new Sprite("src/main/java/archery/assets/archer.png"));
        setX(x);
        setY(y);

        this.world = world;

        powerbar = new Powerbar(getX() - 50, getY(), 20, 200);
        world.addDashboard(powerbar);


        bow = new Bow(world, getX() + 45, getCenterY() - 70);

    }

    @Override
    public void update() {

    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        bow.releaseProjectile(powerbar.getProjectileSpeed());
    }
}
