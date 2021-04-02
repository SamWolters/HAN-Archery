package archery.levelManager;

import archery.Archery;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import processing.core.PVector;

import java.util.ArrayList;

public class LevelManager {
    private ArrayList<Level> levels;
    private Level activeLevel;

    private Archery world;

    public LevelManager(Archery world) {
        this.world = world;

        createLevels();
        setActiveLevel(0);

        loadLevel(activeLevel);
    }

    public void createLevels() {
        levels = new ArrayList<>();

        levels.add(new Level(world, 1, new PVector(0, 10), TargetItems.Balloon, ArrowTypes.Normal));
//        levels.add(new Level(world, 2, new PVector(-10, 10), TargetItems.Vase, ArrowTypes.Strength));
//        levels.add(new Level(world, 3, new PVector(5, 10), TargetItems.Flowerpot, ArrowTypes.Heavy));
//        levels.add(new Level(world, 4, new PVector(-20, 10), TargetItems.Apple, ArrowTypes.Speed));

    }

    public void setActiveLevel(int index) {
        activeLevel = levels.get(index);
    }

    public void loadLevel(Level level) {
        level.load();
    }

    public Level getActiveLevel() {
        return activeLevel;
    }

    public void nextLevel() {
        setActiveLevel(levels.indexOf(activeLevel) + 1);
    }

    public void deletePrevLevelObjects() {
        world.deleteAllGameOBjects();
    }

    public boolean nextLevelExists() {
        return levels.size() != levels.indexOf(activeLevel) + 1;
    }
}
