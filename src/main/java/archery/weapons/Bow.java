package archery.weapons;

import archery.Archery;
import archery.arrow.Arrow;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Bow extends SpriteObject {
    Archery world;
    ArrayList<Arrow> arrows;
    Arrow activeArrow;

    private float rotationRequired = 90;

    /**
     * Create a new AnimatedSpriteObject with a Sprite and set the amount of total frames.
     *
     * @param world The world class
     */
    public Bow(Archery world, float x, float y) {
        super(new Sprite("src/main/java/archery/assets/bow2.png"));
        this.world = world;

        setX(x);
        setY(y);
        setZ(2);

        world.addGameObject(this, x, y);

        arrows = new ArrayList<>();
        addArrow();
    }

    private void addArrow() {
        activeArrow = new Arrow(world, getCenterX(), getCenterY());
    }

    @Override
    public void update() {
        if (activeArrow.collided) {
            arrows.add(activeArrow);
            addArrow();
        }
    }

    @Override
    public void draw(PGraphics g) {
        g.pushMatrix();

        g.translate(getCenterX(), getCenterY());

        g.rotate((float) Math.toRadians(rotationRequired));

        g.image(getImage(), -width / 2, -height / 2);

        g.popMatrix();
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (x >= getCenterX() && y <= getCenterY()) {
            float yLength = y - getCenterY();
            float xLength = x - getCenterX();

            float rotation = (float) Math.toDegrees(Math.tanh(yLength / xLength));

            rotationRequired = rotation;
            activeArrow.setRotation(rotation);
        }
    }

    public void releaseProjectile(float speed) {
        activeArrow.launch(speed);
    }
}
