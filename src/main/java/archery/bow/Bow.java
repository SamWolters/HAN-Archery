package archery.bow;

import archery.Archery;
import archery.arrow.Arrow;
import archery.arrow.SpeedArrow;
import archery.arrow.StrengthArrow;
import archery.enums.ArrowTypes;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Bow extends SpriteObject {
    private final int OFFSET_ARROW = 10;

    Archery world;
    ArrayList<Arrow> arrows = new ArrayList<>();
    Arrow activeArrow;

    private float rotationRequired = 0;
    private ArrowTypes arrowType;

    /**
     * Create a new AnimatedSpriteObject with a Sprite and set the amount of total frames.
     *
     * @param world The world class
     */
    public Bow(Archery world, float x, float y, ArrowTypes arrowType) {
        super(new Sprite(Resources.Images.BOW));
        this.world = world;
        this.arrowType = arrowType;

        setX(x);
        setY(y);
        setZ(2);

        world.addGameObject(this,(int) x,(int) y);

        addArrow();
    }

    private void addArrow() {
        switch (arrowType) {
            case Speed:
                activeArrow = new SpeedArrow(world, new Sprite(Resources.Images.ARROW_TYPE_FOUR), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Strength:
                activeArrow = new StrengthArrow(world, new Sprite(Resources.Images.ARROW_TYPE_TWO), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Heavy:
                activeArrow = new StrengthArrow(world, new Sprite(Resources.Images.ARROW_TYPE_THREE), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Normal:
                activeArrow = new StrengthArrow(world, new Sprite(Resources.Images.ARROW_TYPE_ONE), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;

        }
//        activeArrow = new Arrow(world, getCenterX(), getCenterY());
    }

    public Arrow getActiveArrow() { return activeArrow; }

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
        if (x >= getCenterX() && y <= getCenterY() && world.levelStarted) {
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
