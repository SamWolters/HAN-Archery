package archery.levelManager;

import archery.Archery;
import archery.archer.Archer;
import archery.arrow.Arrow;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import archery.ground.Ground;
import archery.powerbar.Powerbar;
import archery.target.Target;
import archery.wall.Wall;
import archery.weapons.Bow;
import processing.core.PVector;

public class Level {

    private Archery world;
    private PVector forces;
    private TargetItems targetItem;
    private ArrowTypes arrowTypes;

    private Archer archer;
    private Target target;

    private boolean completed;

    public Level(Archery world, PVector forces, TargetItems targetItem, ArrowTypes arrowTypes) {
        this.world = world;

        this.forces = forces;
        this.targetItem = targetItem;
        this.arrowTypes = arrowTypes;
    }

    public void load() {
        Ground ground = new Ground(world);
        world.addGameObject(ground);

        Wall wall = new Wall(world);
        world.addGameObject(wall);

        archer = new Archer(world, 80, world.height - (ground.getHeight() + 280));
        world.addGameObject(archer);

        target = new Target(world, (int) (world.width - wall.getWidth() - 160), (int) (world.height - (ground.getHeight() + 280)));
    }

    public void setCompleted() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
