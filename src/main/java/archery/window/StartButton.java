package archery.window;

import archery.Archery;

public class StartButton extends Button{
    public StartButton(Archery world, float x, float y, float width, float height, String text, int textSize) {
        super(world, x, y, width, height, text, textSize);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
    }
}
