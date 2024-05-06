package Game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 */
public class PauseScreen implements Interface.Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Constructor for a new Pause screen.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * does one frame of pauseScreen.
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * @return if the pauseScreen should stop.
     */
    public boolean shouldStop() { return this.stop; }
}