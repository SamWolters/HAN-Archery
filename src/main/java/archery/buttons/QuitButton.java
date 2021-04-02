package archery.buttons;

import archery.Archery;

public class QuitButton extends Button {
    private Archery world;

    public QuitButton(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(world, x, y, width, height, text, textSize);

        this.world = world;

        System.out.println("Locatie: " + x);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        if ((x >= getX() && x <= getX() + getWidth()) && (y >= getY() && y <= getY() + getHeight())) {
            world.startGame();
        }
    }
}
