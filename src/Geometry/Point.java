package Geometry;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public class Point {

    private double x, y;
    private final double epsilon = 0.0001;
    /**
     * constructor for class Geometry.Point.
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * getter for private double X.
     *
     * @return X
     */

    public double getX() {
        return this.x;
    }

    /**
     * setter for private X.
     *
     * @param x
     */

    public void setX(double x) {
        this.x = x;
    }

    /**
     * getter for Y.
     *
     * @return Y
     */

    public double getY() {
        return this.y;
    }

    /**
     * setter for y.
     *
     * @param y
     */

    public void setY(double y) {
        this.y = y;
    }

    /**
     * returns the distance between this point and a given point.
     *
     * @param p
     * @return distance between P and this point.
     */

    public double distance(Point p) {
        return Math.sqrt(((p.getX() - this.getX()) * (p.getX() - this.getX()))
                + ((p.getY() - this.getY()) * (p.getY() - this.getY())));
    }

    /**
     * comparing doubles is unreliable, so if the.
     * subtraction of both x's and y's and smaller than constant value epsilon,
     * then the two points are the same.
     *
     * @param p
     * @return true or false.
     */

    public boolean equals(Point p) {
        return Math.abs(p.getX() - this.getX()) < epsilon && Math.abs(p.getY()
                - this.getY()) < epsilon;
    }
}

