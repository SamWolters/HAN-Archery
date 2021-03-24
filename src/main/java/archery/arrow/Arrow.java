package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;


public class Arrow extends SpriteObject {
    Archery world;

    private float dx;
    private float dy;
    private float rotation;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     */
    public Arrow(Archery world, float x, float y) {
        super(new Sprite("src/main/java/archery/assets/arrow-2.png"));

        this.world = world;

        setX(x);
        setY(y);
        setZ(3);
        world.addGameObject(this, x, y);
    }

    @Override
    public void draw(PGraphics g) {
        g.pushMatrix();
        //
        g.translate(getX(), getY());

        g.rotate((float) Math.toRadians(rotation));

        g.image(getImage(), -width / 2, -height / 2);

        g.popMatrix();
    }

    @Override
    public void update() {
    }

    public void move(float desX, float desY) {
//        float x = desX - getX();
//        float y = desY - getY();
//
//        double length = Math.sqrt(x*x*y*y);
//
//        x/=length;
//        y/=length;
//
//        x *= getSpeed();
//        y *= getSpeed();
//
//        dx = x;
//        dy = y;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
