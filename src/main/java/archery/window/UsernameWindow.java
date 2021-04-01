package archery.window;

import archery.Archery;
import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class UsernameWindow extends Window {

    private Archery world;

    public ArrayList<Button> buttons;
    private String START_GAME = "Start game";
    private String WINDOW_TITLE = "Username";

    public UsernameWindow(Archery world, int x, int y, float width, float height) {
        super(x, y, width, height);
        this.world = world;

        buttons = new ArrayList<>();

        //Username textfield
        addButton((int) (getX() + getWidth() / 5 - 15), (int) (getY() + getHeight() / 4 + 20), getWidth() / 3 * 2, getHeight() / 6, "Dit word een textfield", Resources.Text.FONTSIZE_S - 3);

        //Dit is processing code maar we zouden hier iets mee kunnen.
//        import java.awt.*;
//        TextField textField = new TextField("Text", 16);
//
//        void setup() {
//            add(textField);
//        }
//
//        void draw () {
//            textField.setLocation(25, 655);
//        }

        //Start game button
        addButton((int) (getX() + getWidth() / 5 - 15), (int) (getY() + getHeight() / 2 + 30), getWidth() / 3 * 2, getHeight() / 6, START_GAME, Resources.Text.FONTSIZE_S - 3);

        TextObject txtOb = createTextObject(WINDOW_TITLE, Resources.Text.FONTSIZE_M, getX() + getWidth() / 3 - 5, getY());

        world.addGameObject(txtOb);
    }

    public void addButton(int x, int y, float width, float height, String title, int textSize) {
        buttons.add(new Button(world, x, y, width, height, title, textSize));
    }

    @Override
    public void update() {

    }
}

