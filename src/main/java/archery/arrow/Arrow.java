package archery.arrow;

import archery.Archery;
import archery.ground.Ground;
import archery.target.Target;
import archery.targetItems.TargetItem;
import archery.wall.Wall;
import archery.window.GameEndedWindow;
import archery.window.GameOverWindow;
import archery.window.LevelAchievedWindow;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Date;
import java.util.List;


public abstract class Arrow extends SpriteObject implements IArrow {
    Archery world;

    public boolean collided = false;

    float rotation, fixedRotation, speed;
    int speedMultiplier = 1;
    int gravityEffect = 0;

    PVector pos;
    PVector forces = new PVector(0, 0);
    PVector traj;
    Boolean launched = false;
    Long lastTimeUpdatedInMs;

    /**
     * Creates a SpriteObject and adds this object to the world.
     * Sets the x, y and z position of the arrow with the given params.
     * Because of collision boxes the width and height are changed.
     *
     * @param world         Loads the whole world
     * @param arrowSprite   Loads the sprite of the arrow
     * @param x             X position of the arrow
     * @param y             Y position of the arrow
     *
     * @see Archery#addGameObject(GameObject this)
     */
    public Arrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(arrowSprite);

        this.world = world;

        setX(x);
        setY(y);
        setZ(3);
        world.addGameObject(this);

        setWidth(130);
        setHeight(16);

        pos = new PVector(x, y);
    }


    /**
     * When the arrow is shot out of the world a new arrow get loaded in.
     *
     */
    @Override
    public void update() {
        if (getX() > world.getWidth() || getY() < 0) {
            world.deleteGameObject(this);
            collided = true;
        }


        setX(getX() + (float) ((speed * speedMultiplier) * Math.sin(fixedRotation)));
        setY(getY() + (float) ((speed * speedMultiplier) * Math.cos(fixedRotation)));

        if (this.launched && !this.collided) {
            Date date = new Date();
            long timeMillis = date.getTime();

            if (lastTimeUpdatedInMs == null) {
                updateProjectile(0);
            } else {
                updateProjectile(timeMillis - lastTimeUpdatedInMs);
            }
            this.lastTimeUpdatedInMs = timeMillis;
        }

    }

    /**
     * In the draw the arrow is draw.
     * The pushMatrix function saves the current coordinate of the arrow.
     * Also the rotation of the arrow is determined.
     *
     *
     * @param g     Uses PGraphics to draw
     *
     * @see PGraphics
     */
    @Override
    public void draw(PGraphics g) {
        g.pushMatrix();

        g.translate(getX(), getY());

        if (fixedRotation != 0) {
            g.rotate((float) Math.toRadians(fixedRotation));
        } else {
            g.rotate((float) Math.toRadians(rotation));
        }

        g.image(getImage(), -width / 2, -height / 2);
        g.popMatrix();
    }

    /**
     *
     * @param rotation      Sets the rotation of the arrow
     */
    public void setRotation(float rotation) { this.rotation = rotation; }

    /**
     * Here are the forces, wind and gravity applied to see launch of the arrow.
     *
     * @param speed     Sets the speed for the arrow
     */
    public void launch(float speed) {
        fixedRotation = rotation;

        forces = setForces(0, 10 + gravityEffect);
        traj = calcLaunchTrajectory(speed, Math.abs(rotation));
        launched = true;
    }

    /**
     *
     * Sets the forces by which the arrow is effected by.
     *
     * @param wind      Sets the wind power
     * @param gravity   Sets the gravity
     * @return          Returns the wind and gravity
     */

    public PVector setForces(float wind, float gravity) {
        return new PVector(wind, gravity);
    }

    /**
     *
     * Here the launch trajectory is calculated with the speed
     * and angle of the arrow.
     *
     * @param speed     Sets the speed of the arrow
     * @param angle     Sets the arrow at which the arrow is shot
     * @return          Returns the calculated launch Trajectory
     */
    public PVector calcLaunchTrajectory(float speed, float angle) {
        return new PVector((speed * (float) Math.cos(Math.toRadians(angle))),
                            -(speed * (float) Math.sin(Math.toRadians(angle))));
    }

    /**
     * Updates the X and Y position of the arrow.
     *
     * @param deltaTime     Calculates the trajectory that had to be set in
     *                      a amount of time
     *
     */
    public void updateProjectile(float deltaTime) {
        float time = deltaTime * .001f;
        traj = PVector.add(traj, PVector.mult(forces, time));

        pos.x = pos.x + (traj.x * time);
        pos.y = pos.y + (traj.y * time);

        setX((int) pos.x);
        setY((int) pos.y);
    }

    /**
     *
     * Checks wether the arrow has collided  with something or not
     *
     * @param collidedGameObjects The GameObjects with which a collision should be detected
     */

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject gameObject: collidedGameObjects) {
            if (gameObject instanceof Ground || gameObject instanceof Wall) {
                this.collided = true;
            }

            if (gameObject instanceof Target) {
                if (world.getLevelStarted()) {
                    this.collided = true;
                    world.setLevelStarted(false);

                    GameOverWindow gameOverWindow = new GameOverWindow(world,world.getWidth() / 3, world.getHeight() / 4, world.getWidth() / 3, 300);
                    world.addGameObject(gameOverWindow);
                }
            }

            if (gameObject instanceof TargetItem) {
                if (!collided) {
                    this.collided = true;
                    ((TargetItem) gameObject).takeDamage(doDamage());

                    if (((TargetItem) gameObject).getHealth() <= 0) {
                        if (world.nextLevelExist()) {
                            LevelAchievedWindow levelAchievedWindow = new LevelAchievedWindow(world,world.getWidth() / 3, world.getHeight() / 4, world.getWidth() / 3, 300);
                            world.addGameObject(levelAchievedWindow);
                        } else {
                            GameEndedWindow gameEndedWindow = new GameEndedWindow(world,world.getWidth() / 3, world.getHeight() / 4, world.getWidth() / 3, 300);
                            world.addGameObject(gameEndedWindow);
                        }
                    }
                }
            }
        }
    }
}
