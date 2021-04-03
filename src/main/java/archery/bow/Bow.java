package archery.bow;

import archery.Archery;
import archery.arrow.*;
import archery.enums.ArrowTypes;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Bow extends SpriteObject {
    private final int OFFSET_ARROW = 10;

    private Archery world;
    private ArrayList<Arrow> arrows = new ArrayList<>();
    private Arrow activeArrow;
    private ArrowTypes arrowType;
    private float rotationRequired = 0;

    /**
     * Creates a SpriteObject and adds it as a game object.
     * With the given params it sets the x, y and z positions and
     * sets the arrow type.
     *
     * @param world         The main class of the application
     * @param x             The x position
     * @param y             The y position
     * @param arrowType     The arrow type that should be loaded
     *
     * @see #addArrow()
     * @see Archery#addGameObject(GameObject gameObject)
     */
    public Bow(Archery world, float x, float y, ArrowTypes arrowType) {
        super(new Sprite(Resources.Images.BOW));
        this.world = world;
        this.arrowType = arrowType;

        setX(x);
        setY(y);
        setZ(2);

        world.addGameObject(this);

        addArrow();
    }

    /**
     * Sets a new Arrow based on the arrow type
     *
     * @see SpeedArrow#SpeedArrow(Archery world , Sprite, float, float)
     * @see StrengthArrow#StrengthArrow(Archery world, Sprite, float, float)
     * @see HeavyArrow#HeavyArrow(Archery world, Sprite, float, float)
     * @see NormalArrow#NormalArrow(Archery world, Sprite, float, float)
     */
    private void addArrow() {
        switch (arrowType) {
            case Speed:
                activeArrow = new SpeedArrow(world, new Sprite(Resources.Images.ARROW_TYPE_FOUR), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Strength:
                activeArrow = new StrengthArrow(world, new Sprite(Resources.Images.ARROW_TYPE_TWO), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Heavy:
                activeArrow = new HeavyArrow(world, new Sprite(Resources.Images.ARROW_TYPE_THREE), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
            case Normal:
                activeArrow = new NormalArrow(world, new Sprite(Resources.Images.ARROW_TYPE_ONE), getCenterX() - OFFSET_ARROW, getCenterY() - OFFSET_ARROW);
                break;
        }
    }

    /**
     * Return the active arrow
     *
     * @return activeArrow
     */
    public Arrow getActiveArrow() { return activeArrow; }

    /**
     * Checks if the activeArrow is not null and is collided.
     * If so the activeArrow is moved to the list arrows and a new
     * arrow is created.
     *
     * @see ArrayList#add(Object e)
     * @see #addArrow()
     */
    @Override
    public void update() {
        if (activeArrow != null && activeArrow.collided) {
            arrows.add(activeArrow);
            addArrow();
        }
    }

    /**
     * Draws the bow sprite with a given rotation
     *
     * @param g     uses PGraphics to draw
     *
     * @see PGraphics
     */
    @Override
    public void draw(PGraphics g) {
        g.pushMatrix();

        g.translate(getCenterX(), getCenterY());

        g.rotate((float) Math.toRadians(rotationRequired));

        g.image(getImage(), -width / 2, -height / 2);

        g.popMatrix();
    }

    /**
     * Handles the mouseMoved event and calculates the rotation.
     *
     * @param x     The x position of the mouse
     * @param y     The y position of the mouse
     *
     * @see Math
     * @see Arrow#setRotation(float rotation)
     */
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

    /**
     * Releases the arrow at a given speed
     *
     * @param speed     the speed of wich the arrow should move
     *
     * @see Arrow#launch(float speed)
     */
    public void releaseProjectile(float speed) {
        activeArrow.launch(speed);
    }
}
