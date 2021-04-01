package archery.window;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class LevelAchievedWindow extends Window {

    private Archery world;

    public ArrayList<Button> buttons;
    private String NEXTLEVEL = "Next level ->";
    private String WINDOW_TITLE = "Level achieved!";

    public LevelAchievedWindow(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);
        this.world = world;

        buttons = new ArrayList<>();

        //Next level button
        addButton((int) (getX() + getWidth() / 5 - 15), (int) (getY() + getHeight() - 70), getWidth() / 3 * 2, getHeight() / 6, NEXTLEVEL, Resources.Text.FONTSIZE_S - 3);

        TextObject txtOb = createTextObject(WINDOW_TITLE, Resources.Text.FONTSIZE_M, getX() + getWidth() / 3 - 50, getY());

        world.addGameObject(txtOb);
    }

    public void addButton(int x, int y, float width, float height, String title, int textSize) {
        buttons.add(new Button(world, x, y, width, height, title, textSize));
    }

    @Override
    public void update() {

    }
}
