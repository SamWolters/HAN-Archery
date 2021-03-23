package archery.weapons;

import archery.Archery;
import archery.arrow.Arrow;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;

public class Bow extends AnimatedSpriteObject implements IWeapon {
    Archery world;
    ArrayList<Arrow> arrows;

    private float rotatiehoek = 45;

    /**
     * Create a new AnimatedSpriteObject with a Sprite and set the amount of total frames.
     *
     * @param world The world class
     */
    public Bow(Archery world) {
        super(new Sprite("src/main/java/archery/assets/bow.png"), 3);

        setCurrentFrameIndex(1);
        setWidth(120);
        setHeight(300);

        this.world = world;
        arrows = new ArrayList<>();

    }

    @Override
    public void shoot() {

    }

    @Override
    public void update() {

    }

    @Override
    public void mouseMoved(int x, int y) {
        System.out.println("x:" + x + " y:" + y);
    }


}
