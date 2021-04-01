package archery.ground;

import archery.Archery;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.tile.Tile;
import nl.han.ica.oopg.tile.TileMap;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.Random;

public class Ground extends GameObject {

    Archery world;
    private ArrayList<GroundTile> tiles;

    public Ground(Archery world) {
        this.world = world;

        setWidth(world.width);
        setHeight(GroundTile.groundSprite.getHeight());
        setX(0);
        setY(world.height - GroundTile.groundSprite.getHeight());
        tiles = new ArrayList<>();
        createGroundTiles();
        setZ(9);
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

    private void createGroundTiles() {
        int amountOfGroundTiles = (int) Math.ceil(world.width / GroundTile.groundSprite.getWidth()) + 1;

        for (int i = 0; i < amountOfGroundTiles; i++) {
            tiles.add(new GroundTile(getX() + (GroundTile.groundSprite.getWidth() * i), getY()));
        }
    }
}
