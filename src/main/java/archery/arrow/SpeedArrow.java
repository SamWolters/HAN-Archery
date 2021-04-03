package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;


/**
 * Creates a new SpriteObject in the category arrows
 * and adds it to the world.
 * Sets the x, y and z position of the arrow with the given params.
 * It also sets a speedMultiplier so that this type of arrow is faster than any other arrow.
 *
 * @see SpeedArrow
 */
public class SpeedArrow extends Arrow {
    public SpeedArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);

        speedMultiplier = 3;
    }


    /**
     *
     * @return      Returns the damage of the arrow
     */
    @Override
    public int doDamage() {
        return 90;
    }
}
