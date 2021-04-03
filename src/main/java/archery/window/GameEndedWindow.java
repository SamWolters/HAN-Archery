package archery.window;

import archery.Archery;
import archery.buttons.QuitButton;
import archery.resources.Resources;

public class GameEndedWindow  extends Window {

    /**
     * Creates a new game window, buttons and text
     *
     * @param world         The main class of the application
     * @param x             The x position
     * @param y             The y position
     * @param width         The window width
     * @param height        The window height
     */
    public GameEndedWindow(Archery world, int x, int y, float width, float height) {
        super(world, x, y, width, height);

        gameObjects.add(new QuitButton(world,getX() + getWidth() / 4 , getY() + getHeight() - 80, getWidth() / 2, getHeight() / 6,  "Quit", Resources.Text.FONTSIZE_S));
        gameObjects.add(textObject("Game completed", Resources.Text.FONTSIZE_L, getX() + getWidth() / 2, getY() + 20));
    }

    @Override
    public void update() { }
}
