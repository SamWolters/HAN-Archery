package archery;

import archery.levelManager.LevelManager;
import archery.window.StartWindow;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

public class Archery extends GameEngine {
    private LevelManager manager;
    private StartWindow start;

    public boolean levelStarted = false;

    public static void main(String[] args) {
        Archery ac = new Archery();

        ac.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1800;
        int worldHeight = 800;

        View view = new View(worldWidth, worldHeight);
        view.setBackground(66, 178,247);

        setView(view);
        size(worldWidth, worldHeight);

        start = new StartWindow(this,getWidth() / 3, height / 4, getWidth() / 3, 300);
        addGameObject(start);

        manager = new LevelManager(this);
        manager.loadLevel(manager.getActiveLevel());
    }

    @Override
    public void update() {
        if (manager.getActiveLevel().isCompleted()) {
            manager.nextLevel();
            manager.deletePrevLevelObjects();
            manager.loadLevel(manager.getActiveLevel());
        }
    }

    public void startGame() {
        levelStarted = true;
        start.delete();
    }

    public void reset() {
        deleteAllGameOBjects();

        levelStarted = true;

        manager.setActiveLevel(0);
        manager.loadLevel(manager.getActiveLevel());
    }

    public void quit() {
        deleteAllGameOBjects();

        start = new StartWindow(this,getWidth() / 3, height / 4, getWidth() / 3, 300);
        addGameObject(start);

        levelStarted = false;

        manager.setActiveLevel(0);
        manager.loadLevel(manager.getActiveLevel());
    }

    public void nextLevel() {
        deleteAllGameOBjects();

        manager.nextLevel();
        manager.loadLevel(manager.getActiveLevel());
    }

    public void setLevelStarted(boolean levelStarted) {
        this.levelStarted = levelStarted;
    }

    public boolean getLevelStarted() {
        return levelStarted;
    }

    public boolean nextLevelExist() {
        return manager.nextLevelExists();
    }
}
