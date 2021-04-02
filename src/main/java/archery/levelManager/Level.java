package archery.levelManager;

import archery.Archery;
import archery.archer.Archer;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import archery.ground.Ground;
import archery.target.Target;
import archery.wall.Wall;
import processing.core.PVector;

public class Level {

    private Archery world;
    public int id;
    private PVector forces;
    private TargetItems targetItem;
    private ArrowTypes arrowType;

    private Archer archer;
    private Target target;
    private LevelDashboard dashboard;

    private boolean completed;

    public Level(Archery world, int id, PVector forces, TargetItems targetItem, ArrowTypes arrowType) {
        this.world = world;

        this.id = id;
        this.forces = forces;
        this.targetItem = targetItem;
        this.arrowType = arrowType;
    }

    public void load() {
        Ground ground = new Ground(world);
        world.addGameObject(ground);

        Wall wall = new Wall(world);
        world.addGameObject(wall);

        archer = new Archer(world, 80, world.height - (ground.getHeight() + 280), arrowType);
        world.addGameObject(archer);

        target = new Target(world, (int) (world.width - wall.getWidth() - 160), (int) (world.height - (ground.getHeight() + 280)), targetItem);

        dashboard = new LevelDashboard(this ,0,0, 200, 100);
        world.addDashboard(dashboard);
    }

    public void setCompleted() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}
