package Game;

import Geometry.Ball;
import Geometry.Line;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interface.Collidable;
import Interface.HitListener;
import Interface.HitNotifier;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public class Block implements Collidable, Sprite, HitNotifier {

    private Geometry.Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * @return the hitlistener.
     */
    public List<HitListener> getHitListeners() {
        return this.hitListeners;
    }

    /**
     * sets this hitlistener.
     *
     * @param hitListeners
     */
    public void setHitListeners(List<HitListener> hitListeners) {
        this.hitListeners = hitListeners;
    }

    /**
     * constructor for rectangle.
     *
     * @param upperLeft
     * @param width
     * @param height
     * @param color
     */
    public Block(Geometry.Point upperLeft, double width, double height, Color color) {
        this.rect = new Geometry.Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * another constructor for rectangle.
     *
     * @param rect
     * @param color
     */
    public Block(Geometry.Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    /**
     * interface Interface.Interface.Collidable.
     *
     * @return this rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }


    /**
     * because a block implements sprite,collidable. the constructor sets both of them up in one command.*
     *
     * @param g - game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * draws the Block.
     *
     * @param d - drawboard
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rect.getX(), (int) rect.getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) rect.getX(), (int) rect.getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    /**
     * for this assignment we dont need to implement this function.
     */
    public void timePassed() {
    }

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * hit function.
     * creates the Rectangle lines, and for each rectanngle which side of the rectangle is hit
     * and for each side of the rectangle it changes the velocity of the ball accordingly.
     *
     * @param hitter          the ball that hit
     * @param collisionPoint  the collision point
     * @param currentVelocity the curr velc
     * @return the velocity vector, after its changed direction.
     */
    public Velocity hit(Ball hitter, Geometry.Point collisionPoint, Velocity currentVelocity) {
        Line[] l1 = this.rect.rectangleLines();
        Line lineColl = new Line(collisionPoint.getX() - 0.15, collisionPoint.getY() - 0.15,
                collisionPoint.getX() + 0.15, collisionPoint.getY() + 0.15);

        if (l1[0].isIntersecting(lineColl)) {
            currentVelocity.setIsDownFalse();
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (l1[1].isIntersecting(lineColl)) {
            currentVelocity.setIsDownTrue();
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (l1[2].isIntersecting(lineColl)) {
            currentVelocity.setIsRightTrue();
            this.notifyHit(hitter);
            return currentVelocity;
        }
        if (l1[3].isIntersecting(lineColl)) {
            currentVelocity.setIsRightFalse();
            this.notifyHit(hitter);
            return currentVelocity;
        }

        return currentVelocity;
    }

    /**
     * notifies that the ball was hit.
     *
     * @param hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        if (listeners.size() == 0) {
            return;
        }
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * removes the sprite and collidable from the game.
     *
     * @param g
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * implements hitlistener funcs.
     *
     * @param hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        if (this.hitListeners == null) {
            this.hitListeners = new ArrayList<>();
        }
        this.hitListeners.add(hl);
    }

    /**
     * implements hitlistener.
     *
     * @param hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
