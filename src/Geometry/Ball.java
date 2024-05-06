package Geometry;

import Collison.CollisionInfo;
import Game.GameLevel;
import Game.GameEnvironment;
import Game.Paddle;
import Interface.Sprite;
import biuoop.DrawSurface;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

/**
 * ball class.
 */

public class Ball implements Sprite {

    /**
     * ball has center, radius, color, velocity, and bounds of which he bounces inside.
     */
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment game;
    private Paddle paddle;

    /**
     * ball constructor with a given point, radius, color and game.
     *
     * @param center
     * @param r
     * @param color
     * @param game
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        setCenter(center);
        setSize(r);
        setColor(color);
        setGame(game);
    }

    /**
     * sets puddle.
     *
     * @param paddle
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * ball constructor by parameters (x,y), radius ,color and game.
     *
     * @param x
     * @param y
     * @param r
     * @param color
     * @param game
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment game) {
        Point p1 = new Point(x, y);
        setCenter(p1);
        setSize(r);
        setColor(color);
        setGame(game);
    }

    /**
     * sets game.
     *
     * @param game
     */
    public void setGame(GameEnvironment game) {
        this.game = game;
    }

    /**
     * sets radius.
     *
     * @param r
     */
    public void setSize(int r) {
        this.r = r;
    }

    /**
     * returns x value of the ball.
     *
     * @return x
     */

    public double getX() {
        return this.center.getX();
    }

    /**
     * returns y value of the ball.
     *
     * @return y
     */

    public double getY() {
        return this.center.getY();
    }


    /**
     * returns radius of the ball.
     *
     * @return radius
     */

    public int getSize() {
        return this.r;
    }

    /**
     * simple setter of the ball center with a given point.
     *
     * @param p
     */

    public void setCenter(Point p) {
        this.center = new Point(p.getX(), p.getY());
    }

    /**
     * velocity setter with a given velocity.
     *
     * @param v
     */

    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * velocity setter with a given dx,dy.
     *
     * @param dx
     * @param dy
     */

    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * returns the velocity.
     *
     * @return velocity
     */

    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * color setter for the ball.
     *
     * @param color
     */

    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * color getter for the ball.
     *
     * @return color of the ball.
     */

    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * center getter for the ball.
     *
     * @return the center of the ball.
     */

    public Point getCenter() {
        return this.center;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface
     */

    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle((int) this.getX(), (int) this.getY(), getSize());
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * removes from game.
     *
     * @param g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * move onestep func,
     * calcualtes each step of the ball to know if it hit something.
     * checks if the ball is in the puddle, and moves it accordingly.
     * checks if the ball hit a collidable, and moves it accordingly.
     */
    public void moveOneStep() {
        Line trajectory = new Line(getCenter().getX(), getCenter().getY(),
                getCenter().getX() + this.velocity.getDx() + this.r,
                getCenter().getY() + this.velocity.getDy() + this.r);
        CollisionInfo cInfo = this.game.getClosestCollision(trajectory);
        if (((this.paddle.getX() <= this.getX()) && (this.getX() <= this.paddle.getX() + this.paddle.getWidth()))
                && (this.paddle.getY() <= this.getY()) && (this.getY() <= this.paddle.getY()
                + this.paddle.getHeight() + 10 - this.r)) {
            if ((this.paddle.getX() <= this.getX()) && (this.getX() <= paddle.getX() + 60)
                    && ((this.paddle.getY() <= this.getY()) && (this.getY() - 30 <= this.paddle.getY()))) {
                this.velocity.setIsRightFalse();
                this.center.setX(this.paddle.getX() - this.r - 10);
            }
            if (((this.paddle.getX() + this.paddle.getWidth() - 60 <= this.getX())
                    && (this.getX() <= this.paddle.getX() + this.paddle.getWidth())
                    && ((this.paddle.getY() <= this.getY()) && (this.getY() - 30 <= this.paddle.getY())))) {
                this.velocity.setIsRightTrue();
                this.center.setX(this.paddle.getX() + this.paddle.getWidth() + this.r + 10);
            }
        } else if (cInfo == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            this.velocity = cInfo.collisionObject().hit(this, cInfo.collisionPoint(), this.velocity);
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
}

