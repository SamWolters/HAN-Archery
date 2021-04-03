package archery.buttons;

import archery.Archery;
import archery.window.GameOverWindow;

public class TryAgainButton extends Button {
    private Archery world;

    /**
     * The GameObject button is added to the world.
     * The button is positioned with Y as X axis.
     * Then the width and height are specified.
     * At last the text passed on in the param and
     * the text size is specified
     *
     * @param world     Loads in the world.
     * @param x         X position of the button
     * @param y         Y position of the button
     * @param width     Width of the button
     * @param height    Height of the button
     * @param text      Adds text to the button
     * @param textSize  Adds text size to the text
     *
     * @see TryAgainButton
     */
    public TryAgainButton(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(world, x, y, width, height, text, textSize);

        this.world = world;
    }

    /**
     * mouseClicked checks wether the selfmade button in the world is clicked.
     * Then it "resets" the game by loading in level 1
     *
     * @param x         X position of the button
     * @param y         Y position of the button
     * @param button    The ID of pressed mouse Button
     */
    @Override
    public void mouseClicked(int x, int y, int button) {
        if ((x >= getX() && x <= getX() + getWidth()) && (y >= getY() && y <= getY() + getHeight())) {
            world.reset();
        }
    }
}
