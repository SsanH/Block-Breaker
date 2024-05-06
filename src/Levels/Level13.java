/*
package Levels;

import Collison.BallRemover;
import Collison.BlockRemover;
import Collison.Counter;
import Collison.SpriteCollection;
import Game.*;
import Geometry.Ball;
import Geometry.Point;
import Geometry.Velocity;
import Interface.Collidable;
import Interface.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level3 extends Game.GameLevel implements Interface.LevelInformation, Interface.Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui = new GUI("Arkanoid", 800, 600);
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    private Color[] color = new Color[]{Color.RED, Color.darkGray, Color.cyan,
            Color.orange, Color.GREEN, Color.MAGENTA};
    private Counter counter = new Counter();
    private BlockRemover blockRemover = new BlockRemover(this, counter);
    private Counter ballCounter = new Counter();
    private Counter score = new Counter();
    private BallRemover ballRemover = new BallRemover(this, ballCounter);
    private ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score, blockRemover.getCounter());
    private ScoreIndicator scoreIndicator = new ScoreIndicator(scoreTrackingListener);
    private AnimationRunner runner = new AnimationRunner(this.gui, this.sleeper);
    private boolean running;
    private KeyboardSensor keyboard = gui.getKeyboardSensor();
    private PauseScreen pauseScreen = new PauseScreen(keyboard);

    */
/**
     * initializes the variables.
     *//*


    public Level3() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
    }

    */
/**
     * adds a Interface.Interface.Collidable object to environment.
     *
     * @param c
     *//*


    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    */
/**
     * adds a Interface.Interface.Sprite object to sprites.
     *
     * @param s
     *//*


    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Geometry.Ball (and Game.Paddle)
    // and add them to the game.

    */
/**
     * initialization of the game, includes balls, rectangles and paddle.
     *//*


    public void initialize() {

        Ball ball = new Ball(200, 200, 4, Color.RED, environment);
        ball.setVelocity(2, 4);
        ball.addToGame(this);
        Ball ball1 = new Ball(200, 200, 4, Color.RED, environment);
        ball1.setVelocity(-2, 4);
        ball1.addToGame(this);
        Ball ball2 = new Ball(200, 200, 4, Color.RED, environment);
        ball2.setVelocity(-1, 6);
        ball2.addToGame(this);
        Ball ball3 = new Ball(200, 200, 4, Color.RED, environment);
        ball3.setVelocity(-2, 3);
        ball3.addToGame(this);

        Geometry.Rectangle recPaddle = new Geometry.Rectangle(new Geometry.Point(400, 540), 150, 30);
        Paddle paddle = new Paddle(gui.getKeyboardSensor(), recPaddle, 7, new Color(51, 51, 255));
        paddle.addToGame(this);
        ball.setPaddle(paddle);
        ball1.setPaddle(paddle);
        ball2.setPaddle(paddle);
        ball3.setPaddle(paddle);

        Block d1 = new Block(new Geometry.Point(0, 0), 800, 20, Color.white);
        d1.addToGame(this);
        Block top = new Block(new Geometry.Point(0, 20), 780, 30, Color.GRAY);
        top.addToGame(this);
        Block down = new Block(new Point(0, 590), 780, 10, Color.red);
        down.addToGame(this);
        down.addHitListener(ballRemover);
        ballRemover.getCounter().increase(4);
        Block left = new Block(new Geometry.Point(0, 20), 30, 580, Color.GRAY);
        left.addToGame(this);
        Block right = new Block(new Geometry.Point(770, 20), 30, 580, Color.GRAY);
        right.addToGame(this);

        this.blocks();
    }

    */
/**
     * removes sprite from game.
     *
     * @param s
     *//*

    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    */
/**
     * removes collidable from game.
     *
     * @param c
     *//*

    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    */
/**
     * runs the game taken directly from the assignment page.
     *//*

    public void run() {
        this.running = true;
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        d.setColor(new Color(30, 153, 97));
        d.fillRectangle(0, 0, 800, 600);
        this.sprites.drawAllOn(d);
        scoreIndicator.drawOn(d);
        d.drawText(600,15,"Level Name: " + this.levelName(), 15);
        this.sprites.notifyAllTimePassed();
        if (counter.getValue() == 0 || ballCounter.getValue() == 0) {
            this.running = false;
            gui.close();
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }


    @Override
    public int numberOfBalls() {
        return ballCounter.getValue();
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        return null;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return ;
    }

    @Override
    public Sprite getBackground() {
        return null;
    }

    @Override
    public List<Block> blocks() {

    }

    @Override
    public int numberOfBlocksToRemove() {
        return blockRemover.getCounter().getValue();
    }
}
*/
