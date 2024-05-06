package Game;

import Interface.Sprite;
import biuoop.DrawSurface;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param scoreTrackingListener the score tracking listener
     */
    public ScoreIndicator(ScoreTrackingListener scoreTrackingListener) {
        this.score = scoreTrackingListener;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(ScoreTrackingListener score) {
        this.score = score;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public ScoreTrackingListener getScore() {
        return this.score;
    }

    /**
     * adds sprite to game.
     * @param g
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * draws score text on game.
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(50, 15, "Score:" + this.score.getCurrentScore().getValue(), 15);
    }

    /**
     * not used yet.
     */
    @Override
    public void timePassed() {
    }
}
