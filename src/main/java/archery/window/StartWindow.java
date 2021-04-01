package archery.window;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class StartWindow extends Window {
    private Archery world;

    public ArrayList<Button> buttons;
    private String STARTGAME_TXT = "Start game";
    private String HIGHSCORES_TXT = "Highscores";
    private String WINDOW_TITLE = "Archery";

    public StartWindow(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);
        this.world = world;

        buttons = new ArrayList<>();

        //Start game button
        addButton((int) (getX() + getWidth() / 5 - 20), (int) (getY() + getHeight() / 3), getWidth() / 3 * 2, getHeight() / 6, STARTGAME_TXT, Resources.Text.FONTSIZE_S - 3);

        //Highscores button
        addButton((int) (getX() + getWidth() / 6), (int) (getY() + getHeight() / 3 + 65), getWidth() / 3 * 2, getHeight() / 6, HIGHSCORES_TXT, Resources.Text.FONTSIZE_S - 3);

        TextObject txtOb = createTextObject(WINDOW_TITLE, Resources.Text.FONTSIZE_M, getX() + getWidth() / 3 + 15, getY());

        world.addGameObject(txtOb);
    }

    public void addButton(int x, int y, float width, float height, String title, int textSize) {
        buttons.add(new Button(world, x, y, width, height, title, textSize));
    }

    @Override
    public void update() {

    }
}
