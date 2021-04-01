package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class SpeedArrow extends Arrow {
    public SpeedArrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(world, arrowSprite, x, y);
    }

    @Override
    public int doDamage() {
        return 50;
    }
}
