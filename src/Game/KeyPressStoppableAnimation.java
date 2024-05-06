package Game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation class.
 */
public class KeyPressStoppableAnimation implements Interface.Animation {
    private KeyboardSensor ks;
    private String key;
    private Interface.Animation animation;
    private boolean running;
    private boolean isPressed;

    /**
     * Constructor.
     *
     * @param sensor    sets keyboard
     * @param key       sets "key" word for the unpause
     * @param animation runs the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Interface.Animation animation) {
        this.ks = sensor;
        this.key = key;
        this.animation = animation;
        this.running = true;
        this.isPressed = true;
    }

    /**
     * does one frame, and checks if the animation is unpaused.
     *
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.ks.isPressed(key) && !this.isPressed) {
            this.running = false;
        }
        if (!this.ks.isPressed(key)) {
            this.isPressed = false;
        }
        this.animation.doOneFrame(d);
    }

    /**
     * @return if the loop should stop.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}