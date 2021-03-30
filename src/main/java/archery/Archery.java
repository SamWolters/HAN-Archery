package archery;

import archery.archer.Archer;
import archery.ground.Ground;
import archery.wall.Wall;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

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
        view.setBackground(66, 178,247);

        setView(view);
        size(worldWidth, worldHeight);

        Archer archer = new Archer(this, 80, 407);
        addGameObject(archer, archer.getX(), archer.getY());

        Ground ground = new Ground(this);
        addGameObject(ground, ground.getX(), ground.getY());

        Wall wall = new Wall(this);
        addGameObject(wall, wall.getX(), wall.getY());
    }

    @Override
    public void update() {

    }
}
