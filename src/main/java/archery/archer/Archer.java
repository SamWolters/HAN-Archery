package archery.archer;

import archery.Archery;
import archery.arrow.Arrow;
import archery.weapons.Bow;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

import java.util.ArrayList;

public class Archer extends SpriteObject {

    Archery world;
    Bow bow;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     * @param world The sprite
     */
    public Archer(Archery world) {
        super(new Sprite("src/main/java/archery/assets/archer.png"));
        setX(50);
        setY(150);

        this.world = world;
        bow = new Bow(world);

        world.addGameObject(bow, 100, 200);

        System.out.println(getX());
        System.out.println(getY());

    }

    @Override
    public void update() {

    }
}
