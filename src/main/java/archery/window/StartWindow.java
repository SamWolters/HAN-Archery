package archery.window;

import archery.Archery;
import archery.resources.Resources;
import processing.core.PGraphics;

public class StartWindow extends Window {
//    private final Archery world;


    public StartWindow(int x, int y, float width, float height) {
        super(x, y, width, height);

//        this.world = world;
//        loadButtons();
    }

    Button button;

    public final int BUTTONWIDTH = 300;
    public final int BUTTONHEIGHT = 50;
    public final String STARTGAME_TEXT = "Start game";
    public final String HIGHSCORES = "Highscores";

    public void draw(PGraphics g) {
        drawButtons(g);
        drawText(g);
    }

    public void drawTextOnButton(PGraphics g) {
        g.textAlign(CENTER);
        g.fill(0, 0, 0);
        g.textSize(Resources.Text.FONTSIZE_M);
        g.text("Archery", getX() + getWidth() / 2, getY() + getHeight() / 7);

        //Start game text
        g.textAlign(CENTER);
        g.textSize(Resources.Text.FONTSIZE_S);
        g.fill(0, 0, 0);
        g.text(STARTGAME_TEXT, getX() + getWidth() / 2 + BUTTONHEIGHT, getY() + getHeight() / 3 + 35);
    }

    public void drawButtonsInWindow(PGraphics g) {
//        button.draw(g);

        g.fill(196, 196, 196);

        //Start game button
        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 3, BUTTONWIDTH, BUTTONHEIGHT);
        g.rect(getX() + getWidth() / 3 - 65, getY() + getHeight() / 2 + BUTTONHEIGHT, BUTTONWIDTH, BUTTONHEIGHT);

    }

//    public void loadButtons() {
//        button = new Button(getX() + getWidth() / 3 - 65, getY() + getHeight() / 3, 200, 50);
//        button.setTitle(STARTGAME_TEXT);
//        world.addDashboard(button);
//    }
}
