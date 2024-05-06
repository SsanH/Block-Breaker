package Game;

import Geometry.Ball;
import Geometry.Line;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interface.Collidable;
import Interface.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Geometry.Rectangle paddle;
    private double velocity;
    private Color color;

    /**
     * @return upperleft point of the rectangle.
     */

    public Geometry.Point getUpperLeft() {
        return paddle.getUpperLeft();
    }

    /**
     * @return x co-ordinate of upperleft point.
     */
    public double getX() {
        return this.paddle.getX();
    }

    /**
     * @return y co-ordinate of upperleft point.
     */
    public double getY() {
        return this.paddle.getY();
    }

    /**
     * @return width of the rectangle.
     */
    public double getWidth() {
        return this.paddle.getWidth();
    }

    /**
     * @return height of the rectangle.
     */
    public double getHeight() {
        return this.paddle.getHeight();
    }

    /**
     * constructor for Game.Paddle.
     *
     * @param keyboard
     * @param paddle
     * @param velocity
     * @param color
     */


    public Paddle(biuoop.KeyboardSensor keyboard, Geometry.Rectangle paddle, double velocity, Color color) {
        this.keyboard = keyboard;
        this.paddle = paddle;
        this.velocity = velocity;
        this.color = color;
    }

    /**
     * simple dx change for each "move".
     * moveleft function, adjusted to the current assignment, so the puddle wont leave the blocks
     */
    public void moveLeft() {
        if (this.paddle.getUpperLeft().getX() > 30) {
            this.paddle.setUpperLeft(this.paddle.getX() - this.velocity, this.paddle.getY());
        }
    }

    /**
     * simple dx change for each "move".
     * moveright function, adjusted to the current assignment, so the puddle wont leave the blocks
     */

    public void moveRight() {
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() < 770) {
            this.paddle.setUpperLeft(this.paddle.getX() + this.velocity, this.paddle.getY());
        }
    }

    /**
     * each "time passed" according to the user input the paddle moves left or right.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * drawOn function, cause Game.Paddle implements Interface.Interface.Sprite.
     *
     * @param d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) this.paddle.getX(), (int) this.paddle.getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.paddle.getX(), (int) this.paddle.getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }

    /**
     * get rectangle cause Game.Paddle implements Interface.Interface.Collidable.
     *
     * @return paddle rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * because the Game.Paddle has different logic than the rest of the "blocks"
     * the paddle is splitted into 5 sections and with each hit the ball moves accordingly.
     * @param hitter the Ball that was hit.
     * @param collisionPoint Collision point
     * @param currentVelocity Current ball velocity
     * @return new velocity vector after hit.
     */

    public Velocity hit(Ball hitter, Geometry.Point collisionPoint, Velocity currentVelocity) {
        Line[] l1 = this.paddle.rectangleLines();
        Line lineColl = new Line(collisionPoint.getX() - 0.3, collisionPoint.getY() - 0.3,
                collisionPoint.getX() + 0.3, collisionPoint.getY() + 0.3);
        if (l1[0].isIntersecting(lineColl)) {
            double[] sections = new double[5];
            sections[0] = this.paddle.getX();
            sections[1] = this.paddle.getX() + this.paddle.getWidth() / 5;
            sections[2] = this.paddle.getX() + 2 * this.paddle.getWidth() / 5;
            sections[3] = this.paddle.getX() + 3 * this.paddle.getWidth() / 5;
            sections[4] = this.paddle.getX() + 4 * this.paddle.getWidth() / 5;
            if ((sections[0] <= collisionPoint.getX()) && (collisionPoint.getX() <= sections[1])) {
                return currentVelocity.fromAngleAndSpeed(300, currentVelocity.calcSpeed());
            }
            if ((sections[1] <= collisionPoint.getX()) && (collisionPoint.getX() <= sections[2])) {
                return currentVelocity.fromAngleAndSpeed(330, currentVelocity.calcSpeed());
            }
            if ((sections[2] <= collisionPoint.getX()) && (collisionPoint.getX() <= sections[3])) {
                currentVelocity.setIsDownFalse();
                return currentVelocity;
            }
            if ((sections[3] <= collisionPoint.getX()) && (collisionPoint.getX() <= sections[4])) {
                return currentVelocity.fromAngleAndSpeed(30, currentVelocity.calcSpeed());
            }
            if ((sections[4] <= collisionPoint.getX()) && (collisionPoint.getX()
                    <= (this.paddle.getX() + this.paddle.getWidth()))) {
                return currentVelocity.fromAngleAndSpeed(60, currentVelocity.calcSpeed());
            }
        }
        if (l1[1].isIntersecting(lineColl)) {
            currentVelocity.setIsDownTrue();
            return currentVelocity;
        }
        if (l1[2].isIntersecting(lineColl)) {
            currentVelocity.setIsRightTrue();
            return currentVelocity;
        }
        if (l1[3].isIntersecting(lineColl)) {
            currentVelocity.setIsRightFalse();
            return currentVelocity;
        }
        return currentVelocity;
    }

    /**
     * cause Game.Paddle implements Interface.Interface.Sprite and Interface.Interface.Collidable.
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}