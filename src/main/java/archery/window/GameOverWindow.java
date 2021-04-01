package archery.window;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class GameOverWindow extends Window {
    private Archery world;

    public ArrayList<Button> buttons;
    private String STARTSCREEN_TXT = "Startscreen";
    private String TRY_AGAIN_TXT = "Try again";
    private String WINDOW_TITLE = "Game over!";

    public GameOverWindow(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);
        this.world = world;

        buttons = new ArrayList<>();

        //Start game button
        addButton((int) (getX() + getWidth() / 6 - 20), (int) (getY() + getHeight() - 70), getWidth() / 3, getHeight() / 6, STARTSCREEN_TXT, Resources.Text.FONTSIZE_S - 3);

        //Highscores button
        addButton((int) (getX() + getWidth() / 2 + 10), (int) (getY() + getHeight() - 70), getWidth() / 3, getHeight() / 6, TRY_AGAIN_TXT, Resources.Text.FONTSIZE_S - 3);

        TextObject txtOb = createTextObject(WINDOW_TITLE, Resources.Text.FONTSIZE_M, getX() + getWidth() / 3 - 10, getY());

        world.addGameObject(txtOb);
    }

    public GameOverWindow(int x, int y, float width, float height) {
        super(x, y, width, height);
    }

    public void addButton(int x, int y, float width, float height, String title, int textSize) {
        buttons.add(new Button(world, x, y, width, height, title, textSize));
    }

    @Override
    public void update() {

    }
}
