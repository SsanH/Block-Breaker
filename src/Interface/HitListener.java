package Interface;

import Game.Block;
import Geometry.Ball;
/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

/**
 * hitlistener interface.
 */
public interface HitListener {
    /**
     * The hitter parameter is the Geometry.Ball that's doing the hitting.
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit
     * @param hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}
