package archery.levelManager;

import archery.resources.Resources;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PGraphics;

public class LevelDashboard extends Dashboard {
    private Level level;

    /**
     * Creates a dashboard with the level information
     *
     * @param level     The level
     * @param x         The x position
     * @param y         The y position
     * @param width     The width of the dashboard
     * @param height    The height of the dashboard
     */
    public LevelDashboard(Level level, float x, float y, float width, float height) {
        super(x, y, width, height);

        this.level = level;
    }

    /**
     * Draws the level information
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        g.noStroke();
        g.fill(66, 178,247);
        g.rect(getX(), getY(), getWidth(), getHeight());

        g.fill(0);
        g.textSize(Resources.Text.FONTSIZE_S);
        g.text("Level: " + level.id, getX() + 30, getY() + 50);

        g.textSize(Resources.Text.FONTSIZE_XS);
        g.text("Wind: " + level.forces.x, getX() + 30, getY() + 90);

        g.textSize(Resources.Text.FONTSIZE_XS);
        g.text("Gravity: " + level.forces.y, getX() + 30, getY() + 110);
    }
}
