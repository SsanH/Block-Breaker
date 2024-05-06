package Interface;

import Game.GameLevel;
import biuoop.DrawSurface;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public interface Sprite {
    /**
     * adds a sprite object to game.
     *
     * @param g
     */
    void addToGame(GameLevel g);

    /**
     * draw the sprite to the screen.
     *
     * @param d
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}