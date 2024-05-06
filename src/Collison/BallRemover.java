package Collison;

import Game.GameLevel;
import Geometry.Ball;
import Interface.HitListener;
import Game.Block;


/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game          the game
     * @param removedBlocks - counter for the removed blocks
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public Counter getCounter() {
        return this.remainingBalls;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return this.game;
    }

    /**
     * when a ball hits the floor, it removes the ball and decreases the amount of balls.
     *
     * @param beingHit - the floor
     * @param hitter   - Ball that hit the floor
     */

    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}

