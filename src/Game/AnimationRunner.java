package Game;

import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * class AnimationRunner.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * constructor.
     *
     * @param gui     sets to gui
     * @param sleeper sets to sleeper
     */
    public AnimationRunner(GUI gui, biuoop.Sleeper sleeper) {
        this.gui = gui;
        this.sleeper = sleeper;
    }

    /**
     * @param animation runs the animation given.
     */
    public void run(Animation animation) {
        this.framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}