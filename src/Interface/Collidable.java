package Interface;

import Geometry.Ball;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangle the collision with happened
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     *
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return new velocity vector after hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}