package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;

public class HeavyArrow  extends Arrow {
    public HeavyArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);

        gravityEffect = 30;
    }

    @Override
    public int doDamage() {
        return 100;
    }
}
