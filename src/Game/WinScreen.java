package Game;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Win screen.
 */
public class WinScreen implements Interface.Animation {

    private int score;
    private boolean running;

    /**
     * Constructor for a new Win screen.
     *
     * @param score the score
     */
    public WinScreen(int score) {
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
     * does one frame of the WinScreen.
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.drawRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(130, 300, "CONGRATULATIONS YOU WON", 30);
        d.drawText(200, 350, "YOUR SCORE IS: " + score, 30);
    }

    /**
     * @return if the WinScreen animation should stop.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}
