package Collison;

import Interface.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */
public class SpriteCollection {

    private java.util.List<Sprite> spriteList;

    /**
     * initializer for spriteList.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * adds a Interface.Interface.Sprite object to spriteList.
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).timePassed();
        }
    }

    /**
     * removes the sprite from tha game.
     *
     * @param s - sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).drawOn(d);
        }
    }
}