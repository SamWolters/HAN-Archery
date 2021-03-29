package archery.arrow;

import archery.Archery;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Date;


public class Arrow extends GameObject {
    Archery world;

    float rotation, fixedRotation, speed;

    PVector pos;
    PVector forces = new PVector(0, 0);
    PVector traj;
    Boolean launched = false;
    Long lastTimeUpdatesInMs;

    /**
     * Create a new SpriteObject with a Sprite object.
     *
     */
    public Arrow(Archery world, float x, float y) {
//        super(new Sprite("src/main/java/archery/assets/arrow-2.png"));

        this.world = world;

        setX(x);
        setY(y);
        setZ(3);
        world.addGameObject(this, x, y);

        pos = new PVector(x, y);
    }

    @Override
    public void update() {
        setX(getX() + (float) (speed * Math.sin(fixedRotation)));
        setY(getY() + (float) (speed * Math.cos(fixedRotation)));

        if (this.launched) {
            Date date = new Date();
            long timeMillis = date.getTime();

            if (lastTimeUpdatesInMs == null) {
                UpdateProjectile(0);
            } else {
                UpdateProjectile(timeMillis - lastTimeUpdatesInMs);
            }
            this.lastTimeUpdatesInMs = timeMillis;
        }
    }

    @Override
    public void draw(PGraphics g) {
        g.pushMatrix();

        g.translate(getX(), getY());

//        if (fixedRotation != 0) {
//            g.rotate((float) Math.toRadians(-fixedRotation));
//        } else {
//            g.rotate((float) Math.toRadians(rotation));
//        }

//        g.image(getImage(), -width / 2, -height / 2);
        g.fill(255, 0, 0);
        g.ellipse(40, 40, 40, 40);
        g.popMatrix();
    }

    public void setRotation(float rotation) { this.rotation = rotation; }

    public void setMovement(float mouseY, int speed) {
        this.speed = speed;
        this.fixedRotation = rotation;

//        final float x = world.width - 150;
//
//        PVector vector = new PVector(0, 0);
//
//        final float lengthX = x - getX();
//        final float lengthY = getY() - mouseY;
//
//        System.out.println(lengthY);
    }

    public void Launch() {
        forces = new PVector(0, 10);
        traj = CalcLaunchTrajectory(120, Math.abs(rotation));
        launched = true;
    }

    private PVector CalcLaunchTrajectory(float speed, float angle) {
        return new PVector((speed * (float) Math.cos(Math.toRadians(angle))),
                            -(speed * (float) Math.sin(Math.toRadians(angle))));
    }

    private void UpdateProjectile(float deltaTime) {
        float time = deltaTime * .001f;
        traj = PVector.add(traj, PVector.mult(forces, time));

        pos.x = pos.x + (traj.x * time);
        pos.y = pos.y + (traj.y * time);

        setX((int) pos.x);
        setY((int) pos.y);
    }
}
