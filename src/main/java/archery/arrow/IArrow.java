package archery.arrow;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import processing.core.PVector;


public interface IArrow extends ICollidableWithGameObjects {
    void setRotation(float rotation);
    void launch(float speed);
    PVector setForces(float wind, float gravity);
    PVector calcLaunchTrajectory(float speed, float angle);
    void updateProjectile(float deltaTime);
    int doDamage();
}
