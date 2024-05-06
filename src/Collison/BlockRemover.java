package Collison;

import Game.Block;
import Game.GameLevel;
import Game.ScoreTrackingListener;
import Geometry.Ball;
import Interface.HitListener;

/**
 * The type Block remover.
 */
// a Collison.BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    private Counter score;
    private ScoreTrackingListener scoreTrackingListener;

    /**
     * Instantiates a new Block remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
        this.score = new Counter();
        this.scoreTrackingListener = new ScoreTrackingListener(score, removedBlocks);
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public Counter getCounter() {
        return this.remainingBlocks;
    }

    /**
     * Gets score tracking listener.
     *
     * @return the score tracking listener
     */
    public ScoreTrackingListener getScoreTrackingListener() {
        return this.getScoreTrackingListener();
    }

    /**
     * Blocks that are hit should be removed
     * from the game. Remember to remove this listener from the block
     * that is being removed from the game.
     *
     * @param beingHit - Block that was hit
     * @param hitter   - ball that hit the Block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);
        scoreTrackingListener.getCurrentScore().increase(5);
        if (remainingBlocks.getValue() == 0) {
            scoreTrackingListener.getCurrentScore().increase(100);
        }
    }
}