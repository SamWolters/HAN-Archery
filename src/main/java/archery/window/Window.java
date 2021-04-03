package archery.window;

import archery.Archery;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Window extends GameObject {
    private Archery world;
    public ArrayList<GameObject> gameObjects;

    /**
     * Creates a new game window, buttons and text
     *
     * @param world         The main class of the application
     * @param x             The x position
     * @param y             The y position
     * @param width         The window width
     * @param height        The window height
     */
    public Window(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);

        this.world = world;
        gameObjects = new ArrayList<>();

        setZ(4);
    }

    @Override
    public void update() { }

    /**
     * Draw the game window background 
     * 
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Creates a textObject and return it
     * 
     * @param text          The text that needs to be displayed
     * @param textSize      The textSize that is used
     * @param x             The x position
     * @param y             The y position
     * 
     * @return textObject
     */
    public TextObject textObject(String text, int textSize, float x, float y) {
        TextObject textObject = new TextObject(text, textSize, CENTER, TOP);
        textObject.setX(x);
        textObject.setY(y);
        textObject.setZ(10);

        world.addGameObject(textObject);

        return textObject;
    }

    /**
     * Deletes the window
     * 
     * @see Archery#deleteGameObject(GameObject gameObject) 
     */
    public void delete() {
        for (GameObject gameObject: gameObjects) {
            world.deleteGameObject(gameObject);
        }

        world.deleteGameObject(this);
    }
}
