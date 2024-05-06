package Collison;

import Geometry.Point;
import Interface.Collidable;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public class CollisionInfo {
    private Point p;
    private Collidable collidable;

    /**
     * constructor for Collison.CollisionInfo.
     *
     * @param p
     * @param collidable
     */
    public CollisionInfo(Point p, Collidable collidable) {
        this.p = p;
        this.collidable = collidable;
    }

    /**
     * @return collisionPoint
     */
    public Point collisionPoint() {
        return this.p;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}