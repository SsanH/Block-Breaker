package Geometry;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */
public class Velocity {

    /**
     * standard dx,dy.
     * and two "flags" that with those flags
     * i can decide the in which quarter of the xy axis the directio of the ball is
     */

    private double dx, dy;
    private boolean isDown, isRight;

    /**
     * sets the isDown boolean to true.
     */
    public void setIsDownTrue() {
        this.isDown = true;
    }

    /**
     * sets the isDown boolean to false.
     */
    public void setIsDownFalse() {
        this.isDown = false;
    }

    /**
     * sets the isRight boolean to true.
     */
    public void setIsRightTrue() {
        this.isRight = true;
    }

    /**
     * sets the isRight boolean to false.
     */
    public void setIsRightFalse() {
        this.isRight = false;
    }

    /**
     * getter for dx.
     *
     * @return dx
     */

    public double getDx() {
        return this.dx;
    }

    /**
     * setter for dx.
     *
     * @param dx
     */

    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * getter for dy.
     *
     * @return dy
     */

    public double getDy() {
        return this.dy;
    }

    /**
     * setter for dy.
     *
     * @param dy
     */

    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * the dx, dy parameters are always positive.
     * the "direction" of the ball is decided by isright and isdown
     *
     * @param dx
     * @param dy
     */

    public Velocity(double dx, double dy) {
        if (dx > 0) {
            this.isRight = true;
            setDx(dx);
        } else {
            this.isRight = false;
            setDx(-dx);
        }
        if (dy > 0) {
            this.isDown = true;
            setDy(dy);
        } else {
            this.isDown = false;
            setDy(-dy);
        }
    }

    /**
     * calculates the speed in a simple formula.
     *
     * @return speed according to (dx,dy)
     */

    public double calcSpeed() {
        double speed;
        speed = Math.sqrt((getDx() * getDx()) + (getDy() * getDy()));
        return speed;
    }

    /**
     * calculate the angle of the vector returns the value in degrees.
     * @return angle in degrees
     */

    public double calcAngle() {
        double angle;
        angle = Math.tan(getDx() / getDy());
        return (angle * (180 / Math.PI));
    }

    /**
     * calculates dx,dy with given angle and speed.
     * dx is sin, because in our our xy axis is flipped
     *
     * @param angle
     * @param speed
     * @return velocity dx,dy
     */

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = (speed * Math.sin(Math.toRadians(angle)));
        double dy = -(1) * (speed * Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy) (thats how velocity applies to points)
     * @param p
     * @return (x + dx, y + dy)
     */
    public Point applyToPoint(Point p) {
        double changedx = this.isRight ? this.dx : -this.dx;
        double changedy = this.isDown ? this.dy : -this.dy;
        Point pVelc = new Point(p.getX() + changedx, p.getY() + changedy);
        return pVelc;
    }
}

