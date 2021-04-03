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

    /**
     * Creates a level manager and loads the levels
     *
     * @param world     The main class of the application
     */
    public LevelManager(Archery world) {
        this.world = world;

        createLevels();
        setActiveLevel(0);

        loadLevel(activeLevel);
    }

    /**
     * Creates all the levels
     */
    public void createLevels() {
        levels = new ArrayList<>();

        levels.add(new Level(world, 1, new PVector(0, 10), TargetItems.Balloon, ArrowTypes.Normal));
        levels.add(new Level(world, 2, new PVector(-10, 10), TargetItems.Vase, ArrowTypes.Strength));
        levels.add(new Level(world, 3, new PVector(5, 10), TargetItems.Flowerpot, ArrowTypes.Heavy));
        levels.add(new Level(world, 4, new PVector(-20, 10), TargetItems.Apple, ArrowTypes.Speed));
    }

    /**
     * Sets a new level active based on the given index
     *
     * @param index
     */
    public void setActiveLevel(int index) {
        activeLevel = levels.get(index);
    }

    /**
     * Loads a level based on the given level
     *
     * @param level     Level that needs to be loaded
     */
    public void loadLevel(Level level) {
        level.load();
    }

    /**
     * Return the active level
     *
     * @return activeLevel
     */
    public Level getActiveLevel() {
        return activeLevel;
    }

    /**
     * Sets the next level as active based on the current active level
     *
     * @see #setActiveLevel(int index)
     */
    public void nextLevel() {
        setActiveLevel(levels.indexOf(activeLevel) + 1);
    }

    /**
     * Checks the level size with the index of the activeLevel
     *
     * @return
     */
    public boolean nextLevelExists() {
        return levels.size() != levels.indexOf(activeLevel) + 1;
    }
}
