package archery;

import archery.archer.Archer;
import archery.arrow.Arrow;
import archery.ground.Ground;
import nl.han.ica.oopg.dashboard.FPSCounter;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;

import java.awt.*;

public class Archery extends GameEngine {

    public static void main(String[] args) {
        Archery ac = new Archery();

        ac.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1800;
        int worldHeight = 800;

        View view = new View(worldWidth, worldHeight);
        view.setBackground(255, 255,255);

        setView(view);
        size(worldWidth, worldHeight);

        Archer archer = new Archer(this, 80, 445);
        addGameObject(archer, archer.getX(), archer.getY());
        Ground ground = new Ground((this));
        addGameObject(ground, ground.getX(), ground.getY());
    }

    @Override
    public void update() {

    }


}
