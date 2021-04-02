package archery.levelManager;

import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;

public class LevelDashboard extends Dashboard {
    private Level level;

    public LevelDashboard(Level level, float x, float y, float width, float height) {
        super(x, y, width, height);

        this.level = level;
    }

    @Override
    public void draw(PGraphics g) {
        g.noStroke();
        g.fill(66, 178,247);
        g.rect(getX(), getY(), getWidth(), getHeight());

        g.fill(0);
        g.textSize(Resources.Text.FONTSIZE_S);
        g.text("Level: " + level.id, getX() + 30, getY() + 50);
    }
}
