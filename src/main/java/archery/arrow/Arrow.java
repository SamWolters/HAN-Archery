package archery.arrow;

import archery.Archery;
import archery.ground.Ground;
import archery.ground.GroundTile;
import archery.levelManager.LevelManager;
import archery.resources.Resources;
import archery.target.Target;
import archery.targetItems.TargetItem;
import archery.wall.Wall;
import archery.wall.WallTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Date;
import java.util.List;


public abstract class Arrow extends SpriteObject implements IArrow {
    public boolean collided = false;
    Archery world;

    float rotation, fixedRotation, speed;

    PVector pos;
    PVector forces = new PVector(0, 0);
    PVector traj;
    Boolean launched = false;
    Long lastTimeUpdatesInMs;

    public Arrow(Archery world, Sprite arrowSprite, float x, float y) {
        super(arrowSprite);

        this.world = world;

        setX(x);
        setY(y);
        setZ(3);
        world.addGameObject(this,(int) x,(int) y);

        setWidth(130);
        setHeight(16);

        pos = new PVector(x, y);
    }

    @Override
    public void update() {
        setX(getX() + (float) (speed * Math.sin(fixedRotation)));
        setY(getY() + (float) (speed * Math.cos(fixedRotation)));

        if (this.launched && !this.collided) {
            Date date = new Date();
            long timeMillis = date.getTime();

            if (lastTimeUpdatesInMs == null) {
                updateProjectile(0);
            } else {
                updateProjectile(timeMillis - lastTimeUpdatesInMs);
            }
            this.lastTimeUpdatesInMs = timeMillis;
        }

    }

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

    public void setRotation(float rotation) { this.rotation = rotation; }

    public void launch(float speed) {
        fixedRotation = rotation;

        forces = setForces(0, 10);
        traj = calcLaunchTrajectory(speed, Math.abs(rotation));
        launched = true;
    }

    public PVector setForces(float wind, float gravity) {
        return new PVector(wind, gravity);
    }

    public PVector calcLaunchTrajectory(float speed, float angle) {
        return new PVector((speed * (float) Math.cos(Math.toRadians(angle))),
                            -(speed * (float) Math.sin(Math.toRadians(angle))));
    }

    public void updateProjectile(float deltaTime) {
        float time = deltaTime * .001f;
        traj = PVector.add(traj, PVector.mult(forces, time));

        pos.x = pos.x + (traj.x * time);
        pos.y = pos.y + (traj.y * time);

        setX((int) pos.x);
        setY((int) pos.y);
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject gameObject: collidedGameObjects) {
            if (gameObject instanceof Ground || gameObject instanceof Wall || gameObject instanceof Target || gameObject instanceof TargetItem) {
                this.collided = true;

                System.out.println(gameObject.getClass());
//                world.setLevelCompleted();
            }
        }
    }
}
