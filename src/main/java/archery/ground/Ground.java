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
        setHeight(getGroundSprite().getHeight());
        setX(0);
        setY(world.height - getGroundSprite().getHeight());
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
        int amountOfGroundTiles = (int) Math.ceil(world.width / getGroundSprite().getWidth()) + 1;

        for (int i = 0; i < amountOfGroundTiles; i++) {
            tiles.add(new GroundTile(getGroundSprite(), getX() + (getGroundSprite().getWidth() * i), getY()));
        }
    }

    private Sprite getGroundSprite() {
        Random rnd = new Random();
        Sprite ground;
        
        switch (rnd.nextInt(3)) {
            case 0:
                ground = new Sprite("src/main/java/archery/assets/groundTypes/ground-type-1.png");
            break;
            case 1:
                ground = new Sprite("src/main/java/archery/assets/groundTypes/ground-type-2.png");
            break;
            case 2:
                ground = new Sprite("src/main/java/archery/assets/groundTypes/ground-type-3.png");
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + rnd.nextInt(3));
        }

        return new Sprite("src/main/java/archery/assets/groundTypes/ground-4.png");
    }
}
