package archery.arrow;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;



public class Arrow extends SpriteObject {

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     */
    public Arrow() {
        super(new Sprite("src/main/java/archery/assets/arrow.png"));
    }

    @Override
    public void update() {

    }
}
