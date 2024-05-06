package Game;

import Collison.CollisionInfo;
import Geometry.Line;
import Geometry.Point;
import Interface.Collidable;

import java.util.ArrayList;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

/**
 * Game.GameEnvironment class
 * holds all the Interface.Interface.Collidable objects.
 */

public class GameEnvironment {

    private java.util.List<Collidable> arrColl;

    // add the given collidable to the environment.

    /**
     * initializer for arrColl.
     */

    public GameEnvironment() {
        this.arrColl = new ArrayList<Collidable>(100);
    }

    /**
     * getsize.
     *
     * @return size of Interface.Interface.Collidable objects
     */
    public int getSize() {
        return this.arrColl.size();
    }

    /**
     * adds a Interface.Interface.Collidable item to list.
     *
     * @param c
     */

    public void addCollidable(Collidable c) {
        this.arrColl.add(c);
    }

    /**
     * adds collidable to gameEnviorment.
     *
     * @param c - collidable
     */
    public void removeCollidable(Collidable c) {
        this.arrColl.remove(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * runs the trajectory through all the items that are Collidable, and seraches for a hit in each item.
     *
     * @param trajectory
     * @return if theres a collison, it will return Collisioninfo, which holds the Collidable item hit,
     * and co-ordinates if there is no hit it will return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo cInfo;
        Point p;
        for (int i = 0; i < getSize(); i++) {
            if (this.arrColl.get(i).getCollisionRectangle().intersectionPoints(trajectory).size() != 0) {
                p = trajectory.closestIntersectionToStartOfLine(this.arrColl.get(i).getCollisionRectangle());
                cInfo = new CollisionInfo(p, this.arrColl.get(i));
                return cInfo;
            }
        }
        return null;
    }
}