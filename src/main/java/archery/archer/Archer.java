package archery.archer;

import archery.Archery;
import archery.arrow.Arrow;
import archery.powerbar.Power_bar;
import archery.weapons.Bow;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import java.awt.Graphics;

import java.util.ArrayList;

public class Archer extends SpriteObject {

    Archery world;
    Bow bow;
    Power_bar power_bar;

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
        bow = new Bow(world, 100, 200);

        /*Zou iets van een soort gradient moeten teken*/
        power_bar = new Power_bar();
        world.addGameObject(power_bar, 100, 20);

        System.out.println(getX());
        System.out.println(getY());

    }

    @Override
    public void update() {

    }
}
