package archery.ground;

import archery.Archery;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.tile.Tile;
import nl.han.ica.oopg.tile.TileMap;
import processing.core.PGraphics;

public class Ground extends SpriteObject {

    Archery world;

    public Ground(Archery world) {
        super(new Sprite("src/main/java/archery/assets/ground_V2.png"));
        this.world = world;
        setWidth(world.width);

//        setHeight(50);
        setX(0);
        setY(world.height- getImage().height);

    }


    @Override
    public void update() {

    }

//    @Override
//    public void draw(PGraphics g) {
//        g.noStroke();
//        g.fill();
//        g.rect(getX(), getY(), getWidth(), getHeight());
//    }
}
