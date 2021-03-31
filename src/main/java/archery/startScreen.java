package archery;

import archery.window.Buttons;
import archery.window.Window;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

public class startScreen extends GameEngine {

    Window window;

    public static void main(String[] args) {
        startScreen ss = new startScreen();

        ss.runSketch();

    }

    @Override
    public void setupGame() {
        int startScreenWidth = 1800;
        int startScreenHeight = 800;
        int windowHeight = 350;
        int windowWidth = 600;

        View view = new View(startScreenWidth, startScreenHeight);
        view.setBackground(171, 171, 171);

        setView(view);
        size(startScreenWidth, startScreenHeight);

        window = new Window(getWidth() / 3, getHeight() / 3 - 50, windowWidth, windowHeight);
        addDashboard(window);

//        buttons = new Buttons(400, 400, 100, 75);


    }

    @Override
    public void update() {

    }
}
