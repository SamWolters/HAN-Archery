package archery;

import archery.levelManager.Level;
import archery.levelManager.LevelManager;
import archery.window.StartWindow;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.view.View;

public class Archery extends GameEngine {
    private LevelManager manager;
    private StartWindow start;

    public boolean levelStarted = false;

    public static void main(String[] args) {
        Archery ac = new Archery();

        ac.runSketch();
    }

    /**
     * Creates the game view with the values from worldWidth and worldHeight.
     * Sets the background color and creates a instance of StartWindow and LevelManager.
     * LevelManager loads the first level.
     *
     * @see #setView(View view)
     * @see #size(int worldWidth, int worldHeight)
     * @see #addGameObject(GameObject gameObject)
     * @see View#View(int worldWidth, int worldHeight)
     * @see View#setBackground(int r, int g, int b)
     * @see StartWindow#StartWindow(Archery this, int x, int y, float width, float height)
     * @see LevelManager#LevelManager(Archery this)
     * @see LevelManager#loadLevel(Level level)
     * @see LevelManager#getActiveLevel()
     */
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
    public void update() { }

    /**
     * Starts the game by setting the levelStarted to true
     * and deleting the start window
     *
     * @see StartWindow#delete()
     */
    public void startGame() {
        levelStarted = true;
        start.delete();
    }

    /**
     * Resets the game back to level one. Does this
     * by deleting all game object, setting active level
     * to 0 and loads it.
     *
     * @see #deleteAllGameOBjects()
     * @see LevelManager#setActiveLevel(int 0)
     * @see LevelManager#loadLevel(Level level)
     * @see LevelManager#getActiveLevel()
     */
    public void reset() {
        deleteAllGameOBjects();

        levelStarted = true;

        manager.setActiveLevel(0);
        manager.loadLevel(manager.getActiveLevel());
    }

    /**
     * Sets the game back to start window. Does this by
     * deleting all the game objects and creating a new instance of
     * start window and assigns this to start. Sets level started
     * to false and set active level back to
     *
     * @see #deleteAllGameOBjects()
     * @see StartWindow#StartWindow(Archery this, int x, int y, float width, float height)
     * @see LevelManager#setActiveLevel(int 0)
     * @see LevelManager#loadLevel(Level level)
     * @see LevelManager#getActiveLevel()
     */
    public void quit() {
        deleteAllGameOBjects();

        start = new StartWindow(this,getWidth() / 3, height / 4, getWidth() / 3, 300);
        addGameObject(start);

        levelStarted = false;

        manager.setActiveLevel(0);
        manager.loadLevel(manager.getActiveLevel());
    }

    /**
     * Sets and loads the next level
     *
     * @see #deleteAllGameOBjects()
     * @see LevelManager#setActiveLevel(int 0)
     * @see LevelManager#loadLevel(Level level)
     * @see LevelManager#getActiveLevel()
     */
    public void nextLevel() {
        deleteAllGameOBjects();

        manager.nextLevel();
        manager.loadLevel(manager.getActiveLevel());
    }

    /**
     * Sets the levelStarted variable
     *
     * @param levelStarted      The value if a level is started or not
     */
    public void setLevelStarted(boolean levelStarted) {
        this.levelStarted = levelStarted;
    }

    /**
     * Gets and return the variable levelStarted
     *
     * @return levelStarted
     */
    public boolean getLevelStarted() {
        return levelStarted;
    }

    /**
     * Checks if there is a next level and return the result
     *
     * @return
     */
    public boolean nextLevelExist() {
        return manager.nextLevelExists();
    }
}
