package Game;

import Collison.BallRemover;
import Collison.BlockRemover;
import Collison.Counter;
import Collison.SpriteCollection;
import Geometry.Ball;
import Geometry.Point;
import Interface.Collidable;
import Interface.LevelInformation;
import Interface.Sprite;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */


/**
 * the Game class, initializes and runs the game.
 */

public class GameLevel implements Interface.Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private biuoop.Sleeper sleeper = new biuoop.Sleeper();
    private Counter counter = new Counter();
    private BlockRemover blockRemover = new BlockRemover(this, this.counter);
    private Counter ballCounter = new Counter();
    private Counter score = new Counter();
    private BallRemover ballRemover = new BallRemover(this, this.ballCounter);
    private ScoreTrackingListener scoreTrackingListener
            = new ScoreTrackingListener(this.score, this.blockRemover.getCounter());
    private ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreTrackingListener);
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation info;
    private boolean flag;
    private Sprite background;

    /**
     * GameLevel Constructor.
     *
     * @param info information about the current level.
     * @param gui  the GUI for the level.
     */
    public GameLevel(LevelInformation info, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.info = info;
        this.flag = true;
        this.gui = gui;
        this.keyboard = gui.getKeyboardSensor();
        this.runner = new AnimationRunner(gui, this.sleeper);
        this.background = info.getBackground();
    }

    /**
     * @return returns the user's score.
     */
    public int getScore() {
        return this.score.getValue();
    }

    /**
     * @return number of balls in the game.
     */
    public int numOfBalls() {
        return this.ballCounter.getValue();
    }

    /**
     * adds a Interface.Collidable object to environment.
     *
     * @param c
     */

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds a Interface.Sprite object to sprites.
     *
     * @param s
     */

    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    // Initialize a new game: create the Blocks and Geometry.Ball (and Game.Paddle)
    // and add them to the game.

    /**
     * initialization of the game, includes balls, rectangles and paddle.
     */

    /**
     * @param paddle initializes balls and adds the paddle interaction to them.
     */
    public void initializeBall(Paddle paddle) {
        for (int i = 0; i < this.info.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 350, 4, new Color(31, 73, 243), this.environment);
            ball.setVelocity(this.info.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setPaddle(paddle);
            this.ballRemover.getCounter().increase(1);
        }
    }

    /**
     * initializes paddle.
     *
     * @return paddle.
     */
    public Game.Paddle initializePaddle() {
        Geometry.Rectangle recPaddle =
                new Geometry.Rectangle(new Geometry.Point(200, 540), this.info.paddleWidth(), 30);
        Paddle paddle = new Paddle(this.gui.getKeyboardSensor(), recPaddle,
                this.info.paddleSpeed(), new Color(51, 51, 255));
        paddle.addToGame(this);
        return paddle;
    }

    /**
     * initializes blocks.
     *
     * @param list the list of blocks.
     */
    public void initializeBlocks(List<Block> list) {
        for (int i = 0; i < this.info.numberOfBlocksToRemove(); i++) {
            list.get(i).addToGame(this);
            list.get(i).addHitListener(this.blockRemover);
            list.get(i).addHitListener(this.scoreTrackingListener);
            this.blockRemover.getCounter().increase(1);
        }
    }

    /**
     * initializes "walls" the blocks that cap the screen.
     */
    public void initializeWalls() {
        Block d1 = new Block(new Geometry.Point(0, 0), 800, 20, Color.white);
        d1.addToGame(this);
        Block top = new Block(new Geometry.Point(0, 20), 780, 30, Color.GRAY);
        top.addToGame(this);
        Block down = new Block(new Point(0, 590), 780, 10, Color.red);
        down.addToGame(this);
        down.addHitListener(this.ballRemover);
        Block left = new Block(new Geometry.Point(0, 20), 30, 580, Color.GRAY);
        left.addToGame(this);
        Block right = new Block(new Geometry.Point(770, 20), 30, 580, Color.GRAY);
        right.addToGame(this);
    }

    /**
     * initializes the game.
     *
     * @param score the score from previous games.
     */
    public void initialize(int score) {
        this.background.addToGame(this);
        this.score.setCounter(score);
        Paddle paddle = initializePaddle();
        initializeBall(paddle);
        List<Block> list = this.info.blocks();
        initializeBlocks(list);
        initializeWalls();
    }

    /**
     * removes sprite from game.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * removes collidable from game.
     *
     * @param c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * runs the game taken directly from the assignment page.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites, this.info));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * @return the flag when to stop the game loop.
     */
    public boolean flag() {
        return this.flag;
    }

    /**
     * draws one animation on the surface.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation pauseKey = new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard));
            this.runner.run(pauseKey);
        }
        this.background.drawOn(d);
        this.sprites.drawAllOn(d);
        this.scoreIndicator.drawOn(d);
        d.drawText(280, 15, "Level Name: " + this.info.levelName(), 15);
        this.sprites.notifyAllTimePassed();
        if (counter.getValue() == 0 || ballCounter.getValue() == 0) {
            this.running = false;
            this.flag = false;
        }
    }

    /**
     * @return if the game should stop.
     */
    public boolean shouldStop() {
        return !this.running;
    }
}