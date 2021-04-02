package archery.window;

import archery.Archery;
import archery.buttons.Button;
import archery.buttons.StartButton;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.TextObject;

public class StartWindow extends Window {
    private Archery world;

    public StartWindow(Archery world, int x, int y, float width, float height) {
        super(world, x, y, width, height);
        this.world = world;

        gameObjects.add(new StartButton(world,getX() + getWidth() / 4 , getY() + getHeight() - 80, getWidth() / 2, getHeight() / 6,  "Start Game", Resources.Text.FONTSIZE_S));
        gameObjects.add(textObject("Achery", Resources.Text.FONTSIZE_L, getX() + getWidth() / 2, getY() + 20));
        gameObjects.add(textObject("Welcome to Achery, this is a 2d shooter game.", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 90));
        gameObjects.add(textObject("You need to hit the target without hitting the person.", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 115));
        gameObjects.add(textObject("Have fun and good luck ;)", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 140));
    }

    @Override
    public void update() {

    }
}
