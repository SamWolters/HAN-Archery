package archery.ground;

import archery.Archery;
import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Ground extends GameObject {
    private Archery world;
    private ArrayList<GroundTile> tiles;

    /**
     * Creates the ground for the world width
     *
     * @param world     The main class of the application
     *
     * @see #createGroundTiles()
     * @see GroundTile#groundSprite#getHeight()
     */
    public Ground(Archery world) {
        this.world = world;

        setX(0);
        setY(world.height - GroundTile.groundSprite.getHeight());
        setZ(9);

        setWidth(world.width);
        setHeight(GroundTile.groundSprite.getHeight());

        tiles = new ArrayList<>();
        createGroundTiles();
    }

    @Override
    public void update() { }

    /**
     * Draws the GroundTiles
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {
        for (GroundTile tile: tiles) {
            tile.draw(g);
        }
    }

    /**
     * Creates the groundTiles
     *
     * @see Math
     * @see GroundTile#GroundTile(float x, float y)
     */
    private void createGroundTiles() {
        int amountOfGroundTiles = (int) Math.ceil(world.width / GroundTile.groundSprite.getWidth()) + 1;

        for (int i = 0; i < amountOfGroundTiles; i++) {
            tiles.add(new GroundTile(getX() + (GroundTile.groundSprite.getWidth() * i), getY()));
        }
    }
}
