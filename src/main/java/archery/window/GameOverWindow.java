package archery.window;

import archery.Archery;
import archery.buttons.Button;
import archery.buttons.StartButton;
import archery.resources.Resources;
import nl.han.ica.oopg.objects.TextObject;

import java.util.ArrayList;

public class GameOverWindow extends Window {
    private Archery world;

    public GameOverWindow(Archery world, int x, int y, float width, float height) {
        super(world, x, y, width, height);
        this.world = world;

        gameObjects.add(new StartButton(world,getX() + getWidth() / 4 , getY() + getHeight() - 80, getWidth() / 2, getHeight() / 6,  "Start Game", Resources.Text.FONTSIZE_S));
        gameObjects.add(textObject("Game Over", Resources.Text.FONTSIZE_L, getX() + getWidth() / 2, getY() + 20));
        gameObjects.add(textObject("Score", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 90));
        gameObjects.add(textObject("Arrows shot:", Resources.Text.FONTSIZE_XS, getX() + getWidth() / 2, getY() + 115));

//        buttons = new ArrayList<>();
//
//        //Start game button
//        addButton((int) (getX() + getWidth() / 6 - 20), (int) (getY() + getHeight() - 70), getWidth() / 3, getHeight() / 6, STARTSCREEN_TXT, Resources.Text.FONTSIZE_S - 3);
//
//        //Highscores button
//        addButton((int) (getX() + getWidth() / 2 + 10), (int) (getY() + getHeight() - 70), getWidth() / 3, getHeight() / 6, TRY_AGAIN_TXT, Resources.Text.FONTSIZE_S - 3);
//
//        TextObject txtOb = textObject(WINDOW_TITLE, Resources.Text.FONTSIZE_M, getX() + getWidth() / 3 - 10, getY());
//
//        world.addGameObject(txtOb);
    }
    @Override
    public void update() {

    }
}
