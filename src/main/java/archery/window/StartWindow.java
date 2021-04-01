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

    public StartWindow(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);
        this.world = world;

        buttons = new ArrayList<>();
        addButton(500, 250, 400, 100, "Start Game", Resources.Text.FONTSIZE_XS);

        TextObject d = createTextObject("hallo", Resources.Text.FONTSIZE_M, 400, 400);

        world.addGameObject(d);
    }

    public void addButton(float x, float y, int width, int height, String title, int textSize) {
        buttons.add(new Button(world, x, y, width, height, title, textSize));
    }

    @Override
    public void update() {

    }
}
