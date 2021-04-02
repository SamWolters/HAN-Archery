package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;

public class NormalArrow  extends Arrow {
    public NormalArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);
    }

    @Override
    public int doDamage() {
        return 100;
    }
}