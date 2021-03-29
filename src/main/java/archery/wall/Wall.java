package archery.wall;

import archery.Archery;
import archery.ground.GroundTile;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Wall extends GameObject {

    Archery world;
    private ArrayList<GroundTile> tiles;

    public Wall(Archery world) {
        this.world = world;

//        setWidth(world.width);

//        setHeight(50);

        setWidth(10);
        setHeight(10);
        setX(getWidth() + 100);

        //De Y gedraagd zich als een X, zet de setY waarden maar is naar 200 ofso.
        //De gehele image is heel groot maar heb hem nu voor een groot deel uit beeld gedaan. Zodat alleen dat linker stukje zichtbaar is.
        setY(1700);
        tiles = new ArrayList<>();
        createSpriteTiles();
        setZ(-1);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        for (GroundTile tile: tiles) {
            tile.draw(g);
        }
    }

    private void createSpriteTiles() {
//        int amountOfWallTiles = (int) Math.ceil(world.width / getWallSprite().getHeight()) + 1;
        int amountOfWallTiles = 1;

        for (int i = 0; i < amountOfWallTiles; i++) {
            tiles.add(new GroundTile(getWallSprite(), getY() + (getWallSprite().getHeight() * i), getX()));
        }
    }

    private Sprite getWallSprite() {
        Sprite wall;
        wall = new Sprite("src/main/java/archery/assets/wall.png");
        return wall;
    }
}
