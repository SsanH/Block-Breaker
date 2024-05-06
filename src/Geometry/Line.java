package Geometry;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

public class Line {

    private Point start, end;
    private static final int INF = 2147483647; // 2^31 - 1
    private static final double EPSILON = 0.0001;

    /**
     * since the variables are private, this returns the starting point.
     *
     * @return Geometry.Point start.
     */
    public Point getStart() {
        return this.start;
    }

    /**
     * since the variables are private, this returns the ending point.
     *
     * @return Geometry.Point end.
     */
    public Point getEnd() {
        return this.end;
    }

    /**
     * set starting point.
     *
     * @param start
     */

    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * set ending point.
     *
     * @param end
     */

    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * two ways to construct a line, first one is with 2 points.
     *
     * @param start
     * @param end
     */

    public Line(Point start, Point end) {
        setStart(start);
        setEnd(end);
    }

    /**
     * second way to construct a line is with 4 parameters of:.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */

    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * simple distance formula to calculate the legnth of the line.
     *
     * @return distance, the length of our line.
     */

    public double length() {
        double distance;
        distance = Math.sqrt(((this.start.getX() - end.getX()) * (this.start.getX() - this.end.getX()))
                + ((this.start.getY() - this.end.getY()) * (this.start.getY() - this.end.getY())));
        return distance;
    }

    /**
     * calculates middle point of the line and returns it.
     *
     * @return the middle point of the Geometry.Line
     */

    public Point middle() {
        Point middle;
        middle = new Point((this.start.getX() + this.end.getX()) / 2,
                ((this.start.getY() + this.end.getY()) / 2));
        return middle;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     * 2 lines that arent parallel will eventually intersect, so
     * we'll check if they slope of those lines are the same;
     *
     * @param other
     * @return checks if two lines are intersecting true if they are,  else false
     */
    public boolean isIntersecting(Line other) {
        return (this.intersectionWith(other) != null);
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect
     * @return if there are more than 2 points of intersection it returns the point nearest to the
     * start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line l1 = new Line(this.start, this.end);
        Point min;

        if (rect.intersectionPoints(l1).size() == 0) {
            return null;
        }
        if (rect.intersectionPoints(l1).size() == 1) {
            min = rect.intersectionPoints(l1).get(0);
            return min;
        } else {
            if (rect.intersectionPoints(l1).get(0).distance(this.start)
                    > rect.intersectionPoints(l1).get(1).distance(this.start)) {
                min = rect.intersectionPoints(l1).get(1);
                return min;
            } else {
                min = rect.intersectionPoints(l1).get(0);
                return min;
            }
        }
    }

    /**
     * @param other the line to check the intersection with.
     * @return if the lines intersects it returns the point of intersection, else it returns null.
     */

    public Point intersectionWith(Line other) {
        //according to the equation : y = mx + b
        double slopeLine1, slopeLine2; //m1 m2
        double intersectionWithYAxis1, intersectionWithYAxis2; //b1 b2
        double xIntersection, yIntersection;
        Point pIntersec = null;
        slopeLine1 = getSlope(this);
        slopeLine2 = getSlope(other);

        if (slopeLine1 == INF && slopeLine2 <= EPSILON) {
            intersectionWithYAxis2 = findIntersectionWithYAxis(other);
            xIntersection = this.getStart().getX();
            yIntersection = intersectionWithYAxis2;
            if (isInDomain(other, new Point(xIntersection, yIntersection))) {
                return new Point(xIntersection, intersectionWithYAxis2);
            }
            return null;
        }

        if (slopeLine2 == INF && slopeLine1 <= EPSILON) {
            intersectionWithYAxis1 = findIntersectionWithYAxis(this);
            xIntersection = other.getStart().getX();
            yIntersection = intersectionWithYAxis1;
            if (isInDomain(other, new Point(xIntersection, yIntersection))) {
                return new Point(other.getStart().getX(), intersectionWithYAxis1);
            } else {
                return null;
            }
        }

        if (slopeLine1 == INF) {
            intersectionWithYAxis2 = findIntersectionWithYAxis(other);
            xIntersection = this.getStart().getX();
            yIntersection = slopeLine2 * this.getStart().getX() + intersectionWithYAxis2;
            if (isInDomain(other, new Point(xIntersection, yIntersection))) {
                return new Point(xIntersection, yIntersection);
            } else {
                return null;
            }
        }
        if (slopeLine2 == INF) {
            intersectionWithYAxis1 = findIntersectionWithYAxis(this);
            xIntersection = other.getStart().getX();
            yIntersection = slopeLine1 * other.getStart().getX() + intersectionWithYAxis1;
            if (isInDomain(other, new Point(xIntersection, yIntersection))) {
                return new Point(xIntersection, yIntersection);
            } else {
                return null;
            }
        } else {
            intersectionWithYAxis1 = findIntersectionWithYAxis(this);
            intersectionWithYAxis2 = findIntersectionWithYAxis(other);
            if ((Math.abs(slopeLine1 - slopeLine2) <= EPSILON
                    && Math.abs(intersectionWithYAxis1 - intersectionWithYAxis2) <= EPSILON)) {
                return null;
            }
            xIntersection = ((intersectionWithYAxis2 - intersectionWithYAxis1) / (slopeLine1 - slopeLine2));
            yIntersection = (slopeLine1 * xIntersection) + intersectionWithYAxis1;
            pIntersec = new Point(xIntersection, yIntersection);
            if (isInDomain(other, pIntersec)) {
                return pIntersec;
            } else {
                return null;
            }
        }
    }

    /**
     * @param other line of intersection.
     * @param p     point of intersection.
     * @return if the point of intersection is between the two lines returns true
     * else false
     */
    public boolean isInDomain(Line other, Point p) {
        double thisDist = Math.max(p.distance(this.start), p.distance(this.end));
        double otherDist = Math.max(p.distance(other.start), p.distance(other.end));

        if (thisDist > this.length() || otherDist > other.length()) {
            return false;
        }
        return true;
    }

    /**
     * according to the formula  y = mx + b, this calculates the slope of the line.
     *
     * @param l1
     * @return the slope of a line
     */

    private double getSlope(Line l1) {
        if (Math.abs(l1.start.getX() - l1.end.getX()) < EPSILON) {
            return INF;
        }
        return ((l1.end.getY() - l1.start.getY()) / (l1.end.getX() - l1.start.getX()));
    }

    /**
     * according to the formula y = mx + b , this calculates the "b" also known as intersection with Y axis.
     *
     * @param l1
     * @return intersection with y axis
     */

    private double findIntersectionWithYAxis(Line l1) {
        double slope = getSlope(l1), intersectionY;
        intersectionY = l1.start.getY() - (slope * l1.start.getX());
        return intersectionY;
    }

    /**
     * equals - return true is the lines are equal, false otherwise.
     *
     * @param other
     * @return true or false
     */

    public boolean equals(Line other) {
        return (Math.abs(this.start.getX() - other.start.getX()) < EPSILON
                && Math.abs(this.start.getY() - other.start.getY()) < EPSILON
                && Math.abs(this.end.getX() - other.end.getX()) < EPSILON
                && Math.abs(this.end.getY() - other.end.getY()) < EPSILON)
                ||
                (Math.abs(this.start.getX() - other.end.getX()) < EPSILON
                        && Math.abs(this.start.getY() - other.end.getY()) < EPSILON
                        && Math.abs(this.end.getX() - other.start.getX()) < EPSILON
                        && Math.abs(this.end.getY() - other.start.getY()) < EPSILON);
    }
}

