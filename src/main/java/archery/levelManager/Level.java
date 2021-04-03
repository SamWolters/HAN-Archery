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
    public int id;
    public PVector forces;

    private Archery world;
    private TargetItems targetItem;
    private ArrowTypes arrowType;
    private Archer archer;
    private LevelDashboard dashboard;

    /**
     * Creates a level
     * @param world             The main class of the application
     * @param id                The id of the level
     * @param forces            The forces reprecent wind and gravity
     * @param targetItem        The target item the needs to be draw
     * @param arrowType         The arrow type that needs the be loaded
     */
    public Level(Archery world, int id, PVector forces, TargetItems targetItem, ArrowTypes arrowType) {
        this.world = world;

        this.id = id;
        this.forces = forces;
        this.targetItem = targetItem;
        this.arrowType = arrowType;
    }

    /**
     * Creates all the game objects that are required
     *
     * @see Ground#Ground(Archery world)
     * @see Wall#Wall(Archery world)
     * @see Archer#Archer(Archery world, float x, float y, ArrowTypes arrowType)
     * @see Target#Target(Archery world, int, int, TargetItems targetItem)
     * @see LevelDashboard#LevelDashboard(Level this, float x, float y, float width, float height)
     */
    public void load() {
        Ground ground = new Ground(world);
        world.addGameObject(ground);

        Wall wall = new Wall(world);
        world.addGameObject(wall);

        archer = new Archer(world, 80, world.height - (ground.getHeight() + 280), arrowType);
        world.addGameObject(archer);

        Target target = new Target(world, (int) (world.width - wall.getWidth() - 160), (int) (world.height - (ground.getHeight() + 280)), targetItem);

        dashboard = new LevelDashboard(this ,0,0, 200, 100);
        world.addDashboard(dashboard);
    }
}
