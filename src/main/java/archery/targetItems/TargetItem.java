package archery.targetItems;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;

public interface TargetItem extends ICollidableWithGameObjects {
    void takeDamage(int damage);
    int getHealth();
}
