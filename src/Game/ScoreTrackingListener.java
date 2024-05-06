package Game;

import Collison.Counter;
import Geometry.Ball;
import Interface.HitListener;

/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    private Counter blocksLeft;


    /**
     * Instantiates a new Score tracking listener.
     *
     * @param currentScore the current score
     * @param blocksLeft   the blocks left
     */
    public ScoreTrackingListener(Counter currentScore, Counter blocksLeft) {
        this.currentScore = currentScore;
        this.blocksLeft = blocksLeft;
    }

    /**
     * Gets current score.
     *
     * @return the current score
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }

    /**
     * tracks the score and adjusts it accordingly.
     *
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (this.blocksLeft.getValue() == 0) {
            this.currentScore.increase(100);
        }
        this.currentScore.increase(5);
    }
}