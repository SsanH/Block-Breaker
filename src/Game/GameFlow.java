package Game;

import Interface.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.List;


/**
 * GameFlow class as requested.
 */
public class GameFlow {

    private GUI gui;
    private WinScreen win;
    private LoseScreen lose;
    private AnimationRunner animation;
    private Sleeper sleeper;

    /**
     * GameFlow Constructor.
     */
    public GameFlow() {
        this.sleeper = new Sleeper();
        this.gui = new GUI("Arkanoid", 800, 600);
        this.win = new WinScreen(0);
        this.lose = new LoseScreen(0);
        this.animation = new AnimationRunner(this.gui, this.sleeper);
    }

    /**
     * @param levels runs the levels that needed to be run accordingly.
     */
    public void runLevels(List<LevelInformation> levels) {
        int score = 0;
        int flag = 1;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.gui);
            level.initialize(score);
            while (level.flag()) {
                level.run();
            }
            score = level.getScore();
            if (level.numOfBalls() == 0) {
                KeyPressStoppableAnimation loseKey = new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                        KeyboardSensor.SPACE_KEY, this.lose);
                this.lose.setScore(score);
                this.animation.run(loseKey);
                flag = 0;
                this.gui.close();
                break;
            }
        }
        if (flag == 1) {
            KeyPressStoppableAnimation winKey = new KeyPressStoppableAnimation(this.gui.getKeyboardSensor(),
                    KeyboardSensor.SPACE_KEY, this.win);
            this.win.setScore(score);
            this.animation.run(winKey);
            this.gui.close();
        }
    }
}
