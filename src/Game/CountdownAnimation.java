package Game;

import Collison.SpriteCollection;
import Interface.LevelInformation;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * CountdownAnimation.
 * 3 .. 2 .. 1.. starts the game, each level.
 */
public class CountdownAnimation implements Interface.Animation {

    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private boolean shouldStop;
    private int counter;

    /**
     * constructor.
     *
     * @param numOfSeconds sets numOfSeconds
     * @param countFrom    sets countFrom
     * @param gameScreen   sets SpriteCollection
     * @param level        sets level
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, LevelInformation level) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.counter = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
        this.shouldStop = true;
    }

    /**
     * does one frame of pause.
     *
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(new Color(0, 60, 255));
        if (this.counter > 0) {
            d.drawText(150, 150, this.counter + " ... ", 90);
        }
        if (this.counter != this.countFrom) {
            this.sleeper.sleepFor((long) (1000 * this.numOfSeconds / this.countFrom));
        }
        this.counter--;
    }

    /**
     * @return if the Animation should stop.
     */
    @Override
    public boolean shouldStop() {
        if (this.counter < 0) {
            return this.shouldStop;
        } else {
            return !this.shouldStop;
        }
    }
}
