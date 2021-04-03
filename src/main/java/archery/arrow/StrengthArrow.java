package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;

/**
 * Creates a new SpriteObject in the category arrows
 * and adds it to the world.
 * Sets the x, y and z position of the arrow with the given params.
 *
 * @see StrengthArrow
 */
public class StrengthArrow extends Arrow{
    public StrengthArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);
    }


    /**
     *
     * @return      Returns the damage of the arrow
     *
     */
    @Override
    public int doDamage() {
        return 200;
    }
}
