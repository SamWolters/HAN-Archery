package archery.levelManager;

import archery.Archery;
import archery.archer.Archer;
import archery.arrow.Arrow;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import archery.bow.Bow;
import processing.core.PVector;

import java.util.ArrayList;

public class LevelManager {
    private ArrayList<Level> levels;
    private Level activeLevel;
    private Level prevLevel;

    private Archery world;

    private Archer archer;
    private Bow bow;
    private Arrow arrow;

    private boolean Completed;

    public LevelManager(Archery world) {
        this.world = world;

        createLevels();
        setActiveLevel(0);

        loadLevel(activeLevel);
    }

    public Level getPrevLevel() {
        return prevLevel;
    }

    public void setActiveLevel(int index) {
        prevLevel = activeLevel;
        activeLevel = levels.get(index);
    }

    public void createLevels() {
        levels = new ArrayList<>();

        levels.add(new Level(world, new PVector(0, 10), TargetItems.Apple, ArrowTypes.Speed));
        levels.add(new Level(world, new PVector(0, 10), TargetItems.Apple, ArrowTypes.Strength));
        levels.add(new Level(world, new PVector(0, 10), TargetItems.Apple, ArrowTypes.Heavy));
        levels.add(new Level(world, new PVector(0, 10), TargetItems.Apple, ArrowTypes.Normal));
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
}
