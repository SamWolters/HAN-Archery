package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;

public class StrengthArrow extends Arrow{
    public StrengthArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);
    }

    @Override
    public int doDamage() {
        return 60;
    }
}
