package archery.wall;

import archery.Archery;
import archery.arrow.Arrow;
import archery.ground.Ground;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall extends GameObject {

    Archery world;
    private ArrayList<WallTile> tiles;
//    final int amountOfWallTiles = 8;

    public Wall(Archery world) {
        this.world = world;

        setWidth(getWallSprite().getWidth());
        setHeight(world.height);

        setX(world.width - getWidth());
        setY(0);

        setZ(1);

        tiles = new ArrayList<>();
        createSpriteTiles();

        System.out.println(getX());
        System.out.println(getY());
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        for (WallTile tile: tiles) {
            tile.draw(g);
        }
    }

    private void createSpriteTiles() {
        for (int i = 0; i < Math.ceil(world.height / getWallSprite().getHeight()); i++) {
            tiles.add(new WallTile(getWallSprite(), getX() - 40, getY() + getWallSprite().getHeight() * i));
        }
    }

    private Sprite getWallSprite() {
        return new Sprite("src/main/resources/wallTexture/wall-texture.png");
    }
}
