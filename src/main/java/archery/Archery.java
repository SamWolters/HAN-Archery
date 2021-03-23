package archery;

import archery.archer.Archer;
import archery.arrow.Arrow;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;

public class Archery extends GameEngine {

    public static void main(String[] args) {
        Archery ac = new Archery();

        ac.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1000;
        int worldHeight = 500;

        View view = new View(worldWidth, worldHeight);

        setView(view);
        size(worldWidth, worldHeight);

//        Arrow arrow = new Arrow();
//
//        addGameObject(arrow, 100, 100);

        Archer archer = new Archer(this);
        addGameObject(archer, 50, 150);
    }

    @Override
    public void update() {

    }


}
