package archery.window;

import archery.Archery;
import archery.buttons.*;
import archery.resources.Resources;

public class LevelAchievedWindow extends Window {

    public LevelAchievedWindow(Archery world, int x, int y, float width, float height) {
        super(world, x, y, width, height);

        gameObjects.add(new QuitButton(world,getX() + getWidth() / 5 - 50 , getY() + getHeight() - 80, getWidth() / 3, getHeight() / 6,  "Quit", Resources.Text.FONTSIZE_S));
        gameObjects.add(new NextLevelButton(world,getX() + getWidth() / 2 + 40, getY() + getHeight() - 80, getWidth() / 3, getHeight() / 6,  "Next level", Resources.Text.FONTSIZE_S));

        gameObjects.add(textObject("Level achieved!", Resources.Text.FONTSIZE_L, getX() + getWidth() / 2, getY() + 20));
        gameObjects.add(textObject("Continue to the next level", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 90));
        gameObjects.add(textObject("or go back to start", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 115));
    }

    @Override
    public void update() {

    }
}
