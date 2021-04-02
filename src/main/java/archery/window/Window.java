package archery.window;

import archery.Archery;
import archery.window.StartWindow;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Window extends GameObject {
    private Archery world;

    public ArrayList<GameObject> gameObjects;

    public Window(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);

        this.world = world;
        gameObjects = new ArrayList<>();

        setZ(4);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.noStroke();
        g.fill(212, 212, 212);
        g.rect(getX(), getY(), getWidth(), getHeight());
    }

    public TextObject textObject(String text, int textSize, float x, float y) {
        TextObject textObject = new TextObject(text, textSize, CENTER, TOP);
        textObject.setX(x);
        textObject.setY(y);
        textObject.setZ(10);

        world.addGameObject(textObject);

        return textObject;
    }

    public void delete() {
        for (GameObject gameObject: gameObjects) {
            world.deleteGameObject(gameObject);
        }

        world.deleteGameObject(this);
    }
}
