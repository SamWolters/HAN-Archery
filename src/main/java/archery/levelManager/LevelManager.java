package archery.levelManager;

import archery.Archery;
import archery.enums.ArrowTypes;
import archery.enums.TargetItems;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PVector;

import java.util.ArrayList;

public class LevelManager extends Dashboard {
    private ArrayList<Level> levels;
    private Level activeLevel;

    private Archery world;

    public LevelManager(Archery world, float x, float y, float width, float height) {
        super(x, y, width, height);

        this.world = world;

        createLevels();
        setActiveLevel(0);

        world.addDashboard(this);
    }

    @Override
    public void update() {
        super.update();

        if (activeLevel.isCompleted()) {

        }
    }

    public void createLevels() {
        levels = new ArrayList<>();

        levels.add(new Level(this, new PVector(0, 10), TargetItems.Apple, ArrowTypes.Normal));
    }

    public void setActiveLevel(int index) {
        activeLevel = levels.get(index);
    }

    public Level getActiveLevel() {
        return activeLevel;
    }

//    public loadActiveLevel() {
//        activeLevel.load();
//    }
}
