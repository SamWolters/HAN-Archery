package archery.levelManager;

import archery.archer.Archer;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import processing.core.PVector;

public class Level {

    private LevelManager manager;
    private PVector forces;
    private TargetItems targetItem;
    private ArrowTypes arrowTypes;

    public boolean completed = false;

    public Level(LevelManager manager, PVector forces, TargetItems targetItem, ArrowTypes arrowTypes) {
        this.manager = manager;

        this.forces = forces;
        this.targetItem = targetItem;
        this.arrowTypes = arrowTypes;
    }

    public void load() {
//        manager.addGameObject(new Archer());
    }

    public boolean isCompleted() {
        return completed;
    }
}
