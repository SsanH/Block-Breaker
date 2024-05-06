package Game;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class Lose screen.
 */
public class LoseScreen implements Interface.Animation {
    private int score;
    private boolean running;


    /**
     * Constructor for a new Lose screen.
     *
     * @param score the score
     */
    public LoseScreen(int score) {
        this.score = score;
        this.running = true;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * does one frame of LoseScreen.
     *
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.drawRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(230, 300, "GAME OVER.", 50);
        d.drawText(230, 380, "YOUR SCORE IS: " + score, 30);
    }

    /**
     * @return if the animation should stop.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
