package archery.buttons;

import archery.Archery;
import archery.window.GameOverWindow;

public class TryAgainButton extends Button {
    private Archery world;

    public TryAgainButton(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(world, x, y, width, height, text, textSize);

        this.world = world;
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        if ((x >= getX() && x <= getX() + getWidth()) && (y >= getY() && y <= getY() + getHeight())) {
            world.reset();
        }
    }
}
