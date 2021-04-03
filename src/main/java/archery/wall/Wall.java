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

    /**
     * Here the wall gets added to the world.
     *
     * @param world    Main class of the application
     */
    public Wall(Archery world) {
        this.world = world;

        setWidth(WallTile.wallSprite.getWidth());
        setHeight(world.height);

        setX(world.width - getWidth());
        setY(0);

        setZ(1);

        tiles = new ArrayList<>();
        createSpriteTiles();
    }

    @Override
    public void update() {

    }

    /**
     * Draws multiple tiles with create a big wall
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        for (WallTile tile: tiles) {
            tile.draw(g);
        }
    }

    /**
     *  Creates the tile it self. Also sets the height to
     *  where the tiles should drew.
     */
    private void createSpriteTiles() {
        for (int i = 0; i < Math.ceil(world.height / WallTile.wallSprite.getHeight()); i++) {
            tiles.add(new WallTile(getX() - 40, getY() + WallTile.wallSprite.getHeight() * i));
        }
    }
}
