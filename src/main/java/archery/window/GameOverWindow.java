package archery.window;

import archery.Archery;
import archery.buttons.QuitButton;
import archery.buttons.TryAgainButton;
import archery.resources.Resources;
public class GameOverWindow extends Window {

    public GameOverWindow(Archery world, int x, int y, float width, float height) {
        super(world, x, y, width, height);

        gameObjects.add(new TryAgainButton(world,getX() + getWidth() / 5 - 50 , getY() + getHeight() - 80, getWidth() / 3, getHeight() / 6,  "Try Again", Resources.Text.FONTSIZE_S));
        gameObjects.add(new QuitButton(world,getX() + getWidth() / 2 + 40, getY() + getHeight() - 80, getWidth() / 3, getHeight() / 6,  "Quit", Resources.Text.FONTSIZE_S));
        gameObjects.add(textObject("Game Over", Resources.Text.FONTSIZE_L, getX() + getWidth() / 2, getY() + 20));
        gameObjects.add(textObject("Score", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 90));
        gameObjects.add(textObject("Arrows shot:", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 115));
    }

    @Override
    public void update() {

    }
}
